package com.example.clotheswarehouse.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
// By using the @Table annotation, we are telling Spring Data to map the table
// name to the table
@Table
public class Brand {
    public enum BrandName {
        BALENCIAGA("Balenciaga"), STONE_ISLAND("Stone Island"), DIOR("Dior"), CHANNEL("Channel");
        private String title;

        private BrandName(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    @Id
    private Long id;
    @NotBlank
    private String name;
    @Min(2021)
    private int yearOfCreation;
    @Min(1000)
    private int price;
    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal rate;
    private BrandName brandNameFrom;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
