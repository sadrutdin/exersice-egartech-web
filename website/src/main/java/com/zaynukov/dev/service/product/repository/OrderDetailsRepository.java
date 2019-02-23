package com.zaynukov.dev.service.product.repository;

import com.zaynukov.dev.dbmodel.CreatedOrderDetailsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends PagingAndSortingRepository<CreatedOrderDetailsEntity, Integer> {
}
