package com.example.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
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

    @ModelAttribute("items")
    public List<ItemDto> getItems() {
        var items = restTemplate.getForObject("http://localhost:8082/api/items", ItemDto[].class);
        return Arrays.asList(items);
    }
}
