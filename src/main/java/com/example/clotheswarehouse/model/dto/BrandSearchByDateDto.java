package com.example.clotheswarehouse.model.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrandSearchByDateDto {
    private String name;
    private String startDate;
    private String endDate;
}
