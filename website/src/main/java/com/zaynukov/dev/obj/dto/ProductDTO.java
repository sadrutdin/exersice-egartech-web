package com.zaynukov.dev.obj.dto;

import com.zaynukov.dev.dbmodel.CreatedOrderDetailsEntity;
import com.zaynukov.dev.dbmodel.CreatedOrderEntity;
import com.zaynukov.dev.obj.jibx.ProductItem;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Общие сведения о продукте
 */
public class ProductDTO {
    private long id;
    /**
     * Имя покупателя
     */
    private String customerName;
    /**
     * Адрес покупателя
     */
    private String customerAddress;
    private String count;
    private String sum;
    /**
     * Дата создания заказа
     */
    private String createDateTime;
    // подробные сведения о продукте
    private String serialId, productName, description, dateOfMassProduction;

    public ProductDTO() {
    }

    public ProductDTO(long id, String customerName, String customerAddress, String count, String sum, String createDateTime, String serialId, String productName, String description, String dateOfMassProduction) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.count = count;
        this.sum = sum;
        this.createDateTime = createDateTime;
        this.serialId = serialId;
        this.productName = productName;
        this.description = description;
        this.dateOfMassProduction = dateOfMassProduction;
    }

    private final static DecimalFormat decimalFormatter = new DecimalFormat("### ### ###");
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static ProductDTO createFrom(CreatedOrderEntity order, CreatedOrderDetailsEntity det, ProductItem productItem) {
        long id = order.getId();
        String customerName = order.getCustomerName();
        String customerAddress = order.getCustomerAddress();
        String createDateTime = order.getCreatedDatetime().toLocalDateTime().format(dateTimeFormatter);
        String sum = decimalFormatter.format(order.getSum());
        String count = decimalFormatter.format(det.getCount());
        String serialId = det.getSerialId();
        String productName, description, dateOfMassProduction;

        if (productItem != null) {
            productName = productItem.getProductName();
            description = productItem.getDescription();
            dateOfMassProduction = productItem.getDate();
        } else {
            productName = "Неизвестно";
            description = "Неизвестно";
            dateOfMassProduction = "Неизвестно";
        }
        return new ProductDTO(
                id, customerName, customerAddress,
                count, sum, createDateTime,
                serialId, productName, description, dateOfMassProduction);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
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

    public String getDateOfMassProduction() {
        return dateOfMassProduction;
    }

    public void setDateOfMassProduction(String dateOfMassProduction) {
        this.dateOfMassProduction = dateOfMassProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return id == that.id &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(customerAddress, that.customerAddress) &&
                Objects.equals(count, that.count) &&
                Objects.equals(sum, that.sum) &&
                Objects.equals(createDateTime, that.createDateTime) &&
                Objects.equals(serialId, that.serialId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dateOfMassProduction, that.dateOfMassProduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, customerAddress, count, sum,
                createDateTime, serialId, productName, description, dateOfMassProduction);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", count='" + count + '\'' +
                ", sum='" + sum + '\'' +
                ", createDateTime='" + createDateTime + '\'' +
                ", serialId='" + serialId + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", dateOfMassProduction='" + dateOfMassProduction + '\'' +
                '}';
    }
}
