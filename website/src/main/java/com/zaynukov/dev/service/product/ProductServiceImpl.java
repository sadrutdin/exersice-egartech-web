package com.zaynukov.dev.service.product;

import com.zaynukov.dev.dbmodel.CreatedOrderEntity;
import com.zaynukov.dev.obj.dto.OrderDTO;
import com.zaynukov.dev.service.product.description.ProductDescriptionService;
import com.zaynukov.dev.service.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductDescriptionService descriptionService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductDescriptionService descriptionService, ProductRepository productRepository) {
        this.descriptionService = descriptionService;
        this.productRepository = productRepository;
    }

    @Override
    public List<OrderDTO> getProductList(int page, int size) {
        Page<CreatedOrderEntity> orderList = productRepository.findAll(PageRequest.of(page, size));
        List<OrderDTO> resultList = new ArrayList<>(orderList.getSize());
        for (CreatedOrderEntity order : orderList) {
            resultList.add(new OrderDTO(order));
        }
        return resultList;
    }
}
