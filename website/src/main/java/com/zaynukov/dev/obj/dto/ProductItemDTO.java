package com.zaynukov.dev.obj.dto;

import java.util.Objects;

public class ProductItemDTO {
    private String serialId;
    private String count;
    private String productName = "Неизвестно";
    private String description = "Неизвестно";
    private String date = "Неизвестно";


    public ProductItemDTO() {
    }

    public ProductItemDTO(String serialId, String count) {
        this.serialId = serialId;
        this.count = count;
    }

    public ProductItemDTO(String serialId, String count, String productName, String description, String date) {
        this.serialId = serialId;
        this.count = count;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductItemDTO that = (ProductItemDTO) o;
        return Objects.equals(serialId, that.serialId) &&
                Objects.equals(count, that.count) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialId, count, productName, description, date);
    }

    @Override
    public String toString() {
        return "ProductItemDTO{" +
                "serialId='" + serialId
                + "', count='" + count
                + "', productName='" + productName
                + "', description='" + description
                + "', date='" + date
                + "'}";
    }
}
