package com.zaynukov.dev.service.product.dao;

import com.zaynukov.dev.dbmodel.CreatedOrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends PagingAndSortingRepository<CreatedOrderEntity, Long> {
}
