package com.zaynukov.dev.jsf;

import com.zaynukov.dev.obj.dto.OrderDTO;
import com.zaynukov.dev.service.product.ProductService;
import com.zaynukov.dev.ws.currentdatetime.DateTimeWsClientService;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean("indexJsfBean")
@SessionScoped
public class IndexBean implements Serializable {

//    private static final Logger logger = LoggerFactory.getLogger(IndexBean.class);

    private final ProductService productService;
    private final DateTimeWsClientService dateTimeService;

    @Inject
    public IndexBean(ProductService productService, DateTimeWsClientService dateTimeService) {
        this.productService = productService;
        this.dateTimeService = dateTimeService;
    }

    private boolean loadedFromXml = false;

    public List<OrderDTO> getOrders() {
        return !loadedFromXml
                ? productService.getProductList(0, 10)
                : productService.loadAndGetProductList(0, 10);
    }

    public String loadXml() {
        loadedFromXml = true;
        return "index.xhtml";
    }

    public String getUpdateCurrentTime() {
        try {
            return "Текущие дата и время: " + dateTimeService.getCurrentDateTime("UTC+3").getCurrentDateTime();
        } catch (Exception e) {
            return "Нет соединения с веб-сервисом получения времени";
        }
    }

//    public void setOrders(List<OrderDTO> orders) {
//        this.orders = orders;
//    }


}
