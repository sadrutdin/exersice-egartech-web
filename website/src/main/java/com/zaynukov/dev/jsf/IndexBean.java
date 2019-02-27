package com.zaynukov.dev.jsf;

import com.zaynukov.dev.obj.dto.OrderDTO;
import com.zaynukov.dev.service.product.ProductService;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

@ManagedBean("IndexBean")
@SessionScoped
public class IndexBean implements Serializable {

    private final ProductService productService;
    private final FacesContext facesContext;

    @Inject
    public IndexBean(ProductService productService, FacesContext facesContext) {
        this.productService = productService;
        this.facesContext = facesContext;
    }

    private List<OrderDTO> orders;
    private boolean loadedFromXml = false;

    @PostConstruct
    private void init() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String param = req.getParameter("load");
        loadedFromXml = "true".equals(param);
    }

//    public List<OrderDTO> loadAndGetOrders() {
//        loadedFromXml = true;
//        return this.getOrders();
//    }

    public List<OrderDTO> getOrders() {
        this.orders = !loadedFromXml
                ? productService.getProductList(0, 10)
                : productService.loadAndGetProductList(0, 10);
        return orders;
    }

//    public void setOrders(List<OrderDTO> orders) {
//        this.orders = orders;
//    }


}
