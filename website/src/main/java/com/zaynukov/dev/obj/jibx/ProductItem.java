package com.zaynukov.dev.obj.jibx;

public class ProductItem {
    private String serialId, productName, description, date;

    public ProductItem() {
    }

    public ProductItem(String serialId, String productName, String description, String date) {
        this.serialId = serialId;
        this.productName = productName;
        this.description = description;
        this.date = date;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
