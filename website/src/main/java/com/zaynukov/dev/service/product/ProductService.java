package com.zaynukov.dev.service.product;

import com.zaynukov.dev.obj.dto.OrderDTO;

import java.util.List;

public interface ProductService {
    /**
     * Возвращает DTO с
     * @param page нумерация страниц начинается с 0
     * @param size количество элементов на странице
     * @return список продуктов
     */
    List<OrderDTO> getProductList(int page, int size);
}
