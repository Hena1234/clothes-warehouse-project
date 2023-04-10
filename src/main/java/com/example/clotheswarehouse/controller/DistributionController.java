package com.example.clotheswarehouse.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.example.clotheswarehouse.model.dto.DistributionCentreDto;

@Controller
@RequestMapping("/distribution")
@CrossOrigin(origins = "http://localhost:8082")
public class DistributionController {
    private RestTemplate restTemplate;

    public DistributionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String dashboard() {
        return "distribution";
    }

    @ModelAttribute("distributions")
    public List<DistributionCentreDto> getDistributionCentres() {
        var distributions = restTemplate.getForObject("http://localhost:8082/api/distributioncentre", DistributionCentreDto[].class);
        return Arrays.asList(distributions);
    }
}