package com.zaynukov.dev.service.product;

import com.zaynukov.dev.dbmodel.CreatedOrderDetailsEntity;
import com.zaynukov.dev.dbmodel.CreatedOrderEntity;
import com.zaynukov.dev.dbmodel.ProductInfoEntity;
import com.zaynukov.dev.obj.dto.OrderDTO;
import com.zaynukov.dev.obj.dto.ProductItemDTO;
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
import java.util.*;

import static java.util.Arrays.asList;

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
    public List<OrderDTO> loadAndGetProductList(int page, int size) {
        List<ProductItem> fromXmlList;
        try {
            fromXmlList = XmlUtils.unmarshalling(
                    Products.class, new ClassPathResource("product.xml")
                            .getInputStream()).getList();
        } catch (IOException | NullPointerException e) {
            logger.info("Ошибка при загрузке xml из ресурсов");
            fromXmlList = Collections.emptyList();
        }


        List<OrderDTO> productList = this.getProductList(page, size);

        if (fromXmlList.isEmpty()) return productList;


        // key - serialId
        Map<String, ProductItem> fromXmlMap = new HashMap<>();
        for (ProductItem item : fromXmlList) {
            fromXmlMap.put(item.getSerialId(), item);
        }


        saveXmlDataToDatabase(fromXmlMap);


        for (OrderDTO order : productList) {
            for (ProductItemDTO product : order.getProductList()) {
                String thatSerialId = product.getSerialId();
                if (thatSerialId == null) continue;
                ProductItem xmlItem = fromXmlMap.get(thatSerialId);
                if (xmlItem == null) continue;
                product.setProductName(xmlItem.getProductName());
                product.setDescription(xmlItem.getDescription());
                product.setDate(xmlItem.getDate());
            }
        }

        return productList;
    }

    /**
     * Сохраняет или обновляет данные в БД, загруженные из XML
     *
     * @param fromXml данные из XML;
     *                ключ - serial id продукта
     */
    private void saveXmlDataToDatabase(Map<String, ProductItem> fromXml) {
        Map<String, ProductInfoEntity> fromBd = new HashMap<>();
        for (ProductInfoEntity ent : productInfoRepository.findBySerialIdInOrderByIdAsc(fromXml.keySet())) {
            fromBd.put(ent.getSerialId(), ent);
        }

        List<ProductInfoEntity> targetList = new ArrayList<>();


        for (Map.Entry<String, ProductItem> entry : fromXml.entrySet()) {
            String keyFromXml = entry.getKey();
            ProductItem xmlItem = entry.getValue();

            ProductInfoEntity dbItem = fromBd.get(keyFromXml);
            if (dbItem != null) {
                dbItem.setProductName(xmlItem.getProductName());
                dbItem.setProductDescription(xmlItem.getDescription());
                dbItem.setSerialDate(xmlItem.getDate());
                targetList.add(dbItem);
            } else {
                targetList.add(
                        new ProductInfoEntity(
                                xmlItem.getSerialId(),
                                xmlItem.getProductName(),
                                xmlItem.getDescription(),
                                xmlItem.getDate()
                        )
                );
            }
        }

        productInfoRepository.saveAll(targetList);
    }


    @PostConstruct
    public void init() {
        orderRepository.deleteAll();
        orderDetailsRepository.deleteAll();

        Iterable<CreatedOrderDetailsEntity> d1 = orderDetailsRepository.saveAll(asList(
                new CreatedOrderDetailsEntity("serial-1", 10),
                new CreatedOrderDetailsEntity("serial-3", 33)
        ));

        Iterable<CreatedOrderDetailsEntity> d2 = orderDetailsRepository.saveAll(asList(
                new CreatedOrderDetailsEntity("serial-2", 10),
                new CreatedOrderDetailsEntity("serial-3", 89),
                new CreatedOrderDetailsEntity("serial-1", 89),
                new CreatedOrderDetailsEntity("serial-4", 66)
        ));

        Iterable<CreatedOrderDetailsEntity> d3 = orderDetailsRepository.saveAll(asList(
                new CreatedOrderDetailsEntity("serial-1", 15),
                new CreatedOrderDetailsEntity("serial-5", 579),
                new CreatedOrderDetailsEntity("serial-6", 1),
                new CreatedOrderDetailsEntity("serial-7", 5)
        ));

        long thisTime = System.currentTimeMillis();


        List<CreatedOrderEntity> orders = new ArrayList<>();
        orders.add(new CreatedOrderEntity(
                "Алексей",
                "Екатеринбург",
                8100L,
                new Date(thisTime - 10200),
                d1
        ));

        orders.add(new CreatedOrderEntity(
                "Герман",
                "Никополь",
                2000L,
                new Date(thisTime - 26500),
                d2
        ));

        orders.add(new CreatedOrderEntity(
                "Марина",
                "Ярославль",
                3500L,
                new Date(thisTime - 69020),
                d3
        ));

        orderRepository.saveAll(orders);
    }


}
