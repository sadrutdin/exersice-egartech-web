package com.zaynukov.dev.service.product;

import com.zaynukov.dev.dbmodel.CreatedOrderDetailsEntity;
import com.zaynukov.dev.dbmodel.CreatedOrderEntity;
import com.zaynukov.dev.obj.dto.ProductDTO;
import com.zaynukov.dev.obj.jibx.ProductItem;
import com.zaynukov.dev.service.product.dao.ProductDAO;
import com.zaynukov.dev.service.product.description.ProductDescriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductDescriptionService descriptionService;
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDescriptionService descriptionService, ProductDAO productDAO) {
        this.descriptionService = descriptionService;
        this.productDAO = productDAO;
    }

    @Override
    public List<ProductDTO> getProductList(int page, int size) {
        Iterable<CreatedOrderEntity> orderList = productDAO.findAll(PageRequest.of(page, size));

        // 'Map' по серийному id товара
        Map<String, ProductItem> map = new HashMap<>();
        try {
            for (ProductItem item : descriptionService.getList()) {
                map.put(item.getSerialId(), item);
            }
        } catch (IOException e) {
            e.printStackTrace();
            map = Collections.emptyMap();
        }

        List<ProductDTO> resultList = new ArrayList<>();

        for (CreatedOrderEntity order : orderList) {
            CreatedOrderDetailsEntity det = order.getDetails();
            resultList.add(ProductDTO.createFrom(order, det, map.get(det.getSerialId())));
        }

        return resultList;

    }
}
