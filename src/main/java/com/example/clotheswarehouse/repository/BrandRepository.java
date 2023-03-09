package com.example.clotheswarehouse.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.clotheswarehouse.model.Brand;
import com.example.clotheswarehouse.model.Brand.BrandName;



@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
    List<Brand> findByBrandNameFrom(BrandName brandName);
    List<Brand> findByNameStartsWithAndCreatedAtBetween(String name, LocalDate startDate, LocalDate endDate);

}
