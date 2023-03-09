package com.example.clotheswarehouse.controller;

import java.util.EnumSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.clotheswarehouse.model.Brand;
import com.example.clotheswarehouse.model.Brand.BrandName;
import com.example.clotheswarehouse.model.User;

import com.example.clotheswarehouse.repository.BrandRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignController
{


    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public String design() {
        return "design";
    }

    @ModelAttribute
    public void brandnames(Model model) {
        var brandnames = EnumSet.allOf(Brand.BrandName.class);
        model.addAttribute("brandnames", brandnames);
        log.info("brandnames converted to string:  {}", brandnames);
    }

    @ModelAttribute
    // This model attribute has a lifetime of a request
    public Brand brand() {
        return Brand
                .builder()
                .build();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
    public String processBrandAddition(@Valid Brand brand, BindingResult result) {
        if (result.hasErrors()) {
            return "design";

        }
        log.info("Processing brand: {}", brand);
        brandRepository.save(brand);
        return "redirect:/brandlist";
    }
    @PostMapping("/deleteAllBrands")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String processFightersDeletion(@AuthenticationPrincipal User user) {
        log.info("Deleting all brands for user: {}", user.getAuthorities());
       brandRepository.deleteAll();
        return "redirect:/design";
    }

}
