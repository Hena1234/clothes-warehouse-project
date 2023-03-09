package com.example.clotheswarehouse.repository;

import com.example.clotheswarehouse.model.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandRepositoryPaginated extends PagingAndSortingRepository<Brand, Long> {
}
