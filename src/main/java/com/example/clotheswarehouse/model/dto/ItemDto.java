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


    private Brand brandName;


    private int yearItem;


    private double price;


    private int quantity;


    private Long distributionCentreId;
    public enum Brand {

        BALENCIAGA("Balenciaga"), CHANEL("Chanel"), DIOR("Dior"), GUCCI("Gucci"), PRADA("Prada");

        private String name;

        private Brand(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


}
