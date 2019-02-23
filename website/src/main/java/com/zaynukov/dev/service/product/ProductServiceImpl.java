package com.zaynukov.dev.service.product;

import com.zaynukov.dev.dbmodel.CreatedOrderDetailsEntity;
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

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @PostConstruct
    private void init() {
        productRepository.deleteAll();

        List<CreatedOrderEntity> orders = new ArrayList<>();
        orders.add(new CreatedOrderEntity(
                "Алексей",
                "Екатеринбург",
                2000L,
                new Timestamp(System.currentTimeMillis() - 10200),
                Arrays.asList(
                        new CreatedOrderDetailsEntity("serial-1", 10),
                        new CreatedOrderDetailsEntity("serial-3", 33)
                )
        ));

        orders.add(new CreatedOrderEntity(
                "Алексей",
                "Екатеринбург",
                2000L,
                new Timestamp(System.currentTimeMillis() - 26500),
                Arrays.asList(
                        new CreatedOrderDetailsEntity("serial-2", 10),
                        new CreatedOrderDetailsEntity("serial-3", 89),
                        new CreatedOrderDetailsEntity("serial-1", 89),
                        new CreatedOrderDetailsEntity("serial-4", 66)
                )
        ));

        orders.add(new CreatedOrderEntity(
                "Марина",
                "Ярославль",
                3500L,
                new Timestamp(System.currentTimeMillis() - 69020),
                Arrays.asList(
                        new CreatedOrderDetailsEntity("serial-1", 15),
                        new CreatedOrderDetailsEntity("serial-5", 579),
                        new CreatedOrderDetailsEntity("serial-6", 1),
                        new CreatedOrderDetailsEntity("serial-7", 5)
                )
        ));


        productRepository.saveAll(orders);
    }
}
