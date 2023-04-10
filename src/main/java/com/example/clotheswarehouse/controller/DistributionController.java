package com.example.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.List;

import com.example.clotheswarehouse.model.dto.ItemDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



import com.example.clotheswarehouse.model.dto.DistributionCentreDto;

@Controller
@RequestMapping("/distributions")
@CrossOrigin(origins = "http://localhost:8082")
public class DistributionController {
    private RestTemplate restTemplate;

    public DistributionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String dashboard() {
        return "distributions";
    }

    @ModelAttribute("distributions")
    public List<DistributionCentreDto> processGetDcs(@RequestParam(value="name", defaultValue="") String name,
                                                     @RequestParam(value="brand") ItemDto.Brand brand) {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("user", "cpan228");

        HttpEntity<String> request = new HttpEntity<>("", headers);
        var url = "http://localhost:8082/api/items/DC/" + name + "/" + brand;

        var distributions = restTemplate.exchange(url, HttpMethod.GET, request, DistributionCentreDto[].class).getBody();
        return Arrays.asList(distributions);
    }
}
