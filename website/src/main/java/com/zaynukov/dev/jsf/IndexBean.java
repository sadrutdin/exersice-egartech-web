package com.zaynukov.dev.jsf;

import com.zaynukov.dev.obj.dto.OrderDTO;
import com.zaynukov.dev.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean("IndexBean")
@SessionScoped
public class IndexBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexBean.class);

    private final ProductService productService;
    private final FacesContext facesContext;

    @Inject
    public IndexBean(ProductService productService, FacesContext facesContext) {
        this.productService = productService;
        this.facesContext = facesContext;
    }

    private List<OrderDTO> orders;
    private boolean loadedFromXml = false;

    public List<OrderDTO> getOrders() {
        this.orders = !loadedFromXml
                ? productService.getProductList(0, 10)
                : productService.loadAndGetProductList(0, 10);
        return orders;
    }

    public String loadXml() {
        loadedFromXml = true;
        return "index.xml";
    }

    public String getUpdateCurrentTime() {
        return "Текущее время: " + new Date().toString();
    }

//    public void setOrders(List<OrderDTO> orders) {
//        this.orders = orders;
//    }


}
