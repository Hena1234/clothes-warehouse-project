package com.example.clotheswarehouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.clotheswarehouse.model.Brand;
import com.example.clotheswarehouse.model.Brand.BrandName;
import com.example.clotheswarehouse.repository.BrandRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class BrandApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrandApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(BrandRepository repository) {
		return args -> {
			repository.save(Brand.builder()
					.name("Mini purple bag")
					.brandNameFrom(BrandName.BALENCIAGA)
					.yearOfCreation(2021)
					.price(2000)
					.rate(new BigDecimal(3.9)).build());

			repository.save(Brand.builder()
					.name("Pink tote bag")
					.brandNameFrom(BrandName.STONE_ISLAND)
					.yearOfCreation(2022)
					.price(2100)
					.rate(new BigDecimal(2.5)).build());

			repository.save(Brand.builder()
					.name("Black Lambskin mini bag")
					.brandNameFrom(BrandName.DIOR)
					.yearOfCreation(2022)
					.price(2200)
					.rate(new BigDecimal(3.5)).build());

			repository.save(Brand.builder()
					.name("Lady D-joy bag")
					.brandNameFrom(BrandName.DIOR)
					.yearOfCreation(2021)
					.price(25000)
					.rate(new BigDecimal(4.5)).build());

			repository.save(Brand.builder()
					.name("Dior 2002")
					.brandNameFrom(BrandName.DIOR)
					.yearOfCreation(2021)
					.price(25000)
					.rate(new BigDecimal(4.5)).build());

			repository.save(Brand.builder()
					.name("Balenciaga")
					.brandNameFrom(BrandName.BALENCIAGA)
					.yearOfCreation(2021)
					.price(25000)
					.rate(new BigDecimal(4.5)).build());

			repository.save(Brand.builder()
					.name("STONE BAG")
					.brandNameFrom(BrandName.STONE_ISLAND)
					.yearOfCreation(2021)
					.price(25000)
					.rate(new BigDecimal(4.5)).build());
			repository.save(Brand.builder()
					.name("DIOR BAG 2023 ")
					.brandNameFrom(BrandName.DIOR)
					.yearOfCreation(2021)
					.price(25000)
					.rate(new BigDecimal(4.5)).build());
		};
	}
}
