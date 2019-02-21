package com.zaynukov.dev.service.product.description;

import com.zaynukov.dev.obj.jibx.ProductItem;

import java.io.IOException;
import java.util.List;

public interface ProductDescriptionService {
    void save(List<ProductItem> productList);

    List<ProductItem> getList() throws IOException;
}
