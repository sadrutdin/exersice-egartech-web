package com.zaynukov.dev.obj.dto;

import java.util.Objects;

public class ProductItemDTO {
    private String serialId;
    private String count;


    public ProductItemDTO() {
    }

    public ProductItemDTO(String serialId, String count) {
        this.serialId = serialId;
        this.count = count;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductItemDTO productItemDTO = (ProductItemDTO) o;
        return Objects.equals(serialId, productItemDTO.serialId) &&
                Objects.equals(count, productItemDTO.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialId, count);
    }

    @Override
    public String toString() {
        return "ProductItemDTO{" +
                "serialId='" + serialId + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
