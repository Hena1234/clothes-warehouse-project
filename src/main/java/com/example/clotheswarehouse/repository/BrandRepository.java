package com.example.clotheswarehouse.repository;

import com.example.clotheswarehouse.model.Brand;
import com.example.clotheswarehouse.model.Brand.BrandName;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

//It will be an interface that defines operations with the fighter
//table in the database
public interface BrandRepository extends CrudRepository<Brand, Long> {
    List<Brand> findByBrandNameFrom(BrandName brandName);
    List<Brand> findByNameStartsWithAndCreatedAtBetween(String name, LocalDate startDate, LocalDate endDate);

}
