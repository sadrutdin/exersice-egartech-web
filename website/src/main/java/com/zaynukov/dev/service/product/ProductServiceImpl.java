package com.zaynukov.dev.service.product;

import com.zaynukov.dev.dbmodel.CreatedOrderDetailsEntity;
import com.zaynukov.dev.dbmodel.CreatedOrderEntity;
import com.zaynukov.dev.dbmodel.ProductInfoEntity;
import com.zaynukov.dev.obj.dto.OrderDTO;
import com.zaynukov.dev.obj.jibx.ProductItem;
import com.zaynukov.dev.obj.jibx.Products;
import com.zaynukov.dev.service.product.description.ProductDescriptionService;
import com.zaynukov.dev.service.product.repository.OrderDetailsRepository;
import com.zaynukov.dev.service.product.repository.OrderRepository;
import com.zaynukov.dev.service.product.repository.ProductInfoRepository;
import com.zaynukov.dev.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductInfoRepository productInfoRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductDescriptionService descriptionService;

    @Autowired
    public ProductServiceImpl(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository, ProductDescriptionService descriptionService, ProductInfoRepository productInfoRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.descriptionService = descriptionService;
        this.productInfoRepository = productInfoRepository;
    }

    @Override
    public List<OrderDTO> getProductList(int page, int size) {
        Page<CreatedOrderEntity> orderList = orderRepository.findAll(PageRequest.of(page, size));
        List<OrderDTO> resultList = new ArrayList<>(orderList.getSize());
        for (CreatedOrderEntity order : orderList) {
            resultList.add(new OrderDTO(order));
        }
        return resultList;
    }

    @Override
    public List<ProductItem> loadAndSaveProductInfo() {
        List<ProductItem> list;
        try {
            list = XmlUtils.unmarshalling(
                    Products.class, new ClassPathResource("product.xml")
                            .getInputStream()).getList();
        } catch (IOException | NullPointerException e) {
            logger.info("Ошибка при загрузке xml из ресурсов");
            list = Collections.emptyList();
        }
        if (list.isEmpty()) return list;

        List<ProductInfoEntity> productInfoEntityList = new ArrayList<>();
        for (ProductItem item : list) {
            productInfoEntityList.add(new ProductInfoEntity(item.getSerialId(), item.getProductName(),
                    item.getDescription(), item.getDate()));
        }
        productInfoRepository.saveAll(productInfoEntityList);

        return list;
    }

    @PostConstruct
    public void init() {
        orderRepository.deleteAll();
        orderDetailsRepository.deleteAll();

        Iterable<CreatedOrderDetailsEntity> itt = orderDetailsRepository.saveAll(Arrays.asList(new CreatedOrderDetailsEntity("serial-1111", 1000)));
        for (CreatedOrderDetailsEntity createdOrderDetailsEntity : itt) {
            logger.info(createdOrderDetailsEntity.toString());
        }

        List<CreatedOrderEntity> orders = new ArrayList<>();
        orders.add(new CreatedOrderEntity(
                "Алексей",
                "Екатеринбург",
                8100L,
                new Timestamp(System.currentTimeMillis() - 10200),
                Arrays.asList(
                        new CreatedOrderDetailsEntity("serial-1", 10),
                        new CreatedOrderDetailsEntity("serial-3", 33)
                )
        ));

        orders.add(new CreatedOrderEntity(
                "Герман",
                "Никополь",
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

        orderRepository.saveAll(orders);
    }


}
