package com.example.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import com.example.clotheswarehouse.model.Brand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.clotheswarehouse.model.dto.ItemDto;

@Controller
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:8082")
public class ItemController {
    private RestTemplate restTemplate;

    public ItemController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String dashboard() {
        return "item";
    }
    @ModelAttribute
    public void brandnames(Model model) {
        var brandnames = EnumSet.allOf(Brand.BrandName.class);
        model.addAttribute("brandnames", brandnames);

    }

    @ModelAttribute
    // This model attribute has a lifetime of a request
    public Brand brand() {
        return Brand
                .builder()
                .build();
    }

}
