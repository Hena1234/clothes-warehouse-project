package com.example.clotheswarehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long id;


    private String name;


    private String brandName;


    private int yearItem;


    private double price;


    private int quantity;


    private Long distributionCentreId;

}
