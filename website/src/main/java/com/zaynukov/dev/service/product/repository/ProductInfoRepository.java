package com.zaynukov.dev.service.product.repository;

import com.zaynukov.dev.dbmodel.ProductInfoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductInfoRepository extends PagingAndSortingRepository<ProductInfoEntity, Integer> {
    List<ProductInfoEntity> findBySerialIdInOrderByIdAsc(Collection<String> serialId);
}
