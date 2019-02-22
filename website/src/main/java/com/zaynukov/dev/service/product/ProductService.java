package com.zaynukov.dev.service.product;

import com.zaynukov.dev.obj.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductList(int page, int size);
}
