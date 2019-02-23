package com.zaynukov.dev.service.product.repository;

import com.zaynukov.dev.dbmodel.ProductInfoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends PagingAndSortingRepository<ProductInfoEntity, Integer> {
}
