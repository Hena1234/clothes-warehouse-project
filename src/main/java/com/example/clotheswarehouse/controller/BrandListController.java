package com.example.clotheswarehouse.controller;

import java.util.EnumSet;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.clotheswarehouse.repository.BrandRepositoryPaginated;
import com.example.clotheswarehouse.repository.BrandRepository;
import com.example.clotheswarehouse.model.dto.BrandSearchByDateDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/brandlist")
public class BrandListController {
    private static final int PAGE_SIZE = 10;
    private BrandRepository brandRepository;
    private BrandRepositoryPaginated brandRepositoryPaginated;
    public BrandListController(BrandRepository brandRepository,
                               BrandRepositoryPaginated brandRepositoryPaginated) {
        this.brandRepository = brandRepository;
        this.brandRepositoryPaginated  = brandRepositoryPaginated ;
    }

    @GetMapping
    public String showBrands(Model model) {
        return "brandlist";
    }

    @ModelAttribute
    public void brands(Model model) {
        var brandPage = brandRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("brands", brandPage);
        model.addAttribute("currentPage", brandPage.getNumber());
        model.addAttribute("totalPages", brandPage.getTotalPages());
    }

    @ModelAttribute
    public void brandsByDateDto(Model model) {
        model.addAttribute("brandsByDateDto", new BrandSearchByDateDto());
    }

    @PostMapping
    public String searchBrandsByDate(@ModelAttribute BrandSearchByDateDto brandsByDateDto,
                                     Model model) {
        var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("brands", brandRepository.findByNameStartsWithAndCreatedAtBetween(
                brandsByDateDto.getName(), LocalDate.parse( brandsByDateDto.getStartDate(), dateFormatter),
                LocalDate.parse( brandsByDateDto.getEndDate(), dateFormatter)));
        return "brandlist";
    }


}