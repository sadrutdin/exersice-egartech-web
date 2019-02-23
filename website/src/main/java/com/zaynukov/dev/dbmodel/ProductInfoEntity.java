package com.zaynukov.dev.dbmodel;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
@Table(name = "product_info", schema = "public", catalog = "exercise")
public class ProductInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "serial_id", nullable = false)
    private String serialId;
    @Basic
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Basic
    @Column(name = "product_description", nullable = true)
    private String productDescription;
    @Basic
    @Column(name = "serial_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date serialDate;

    public ProductInfoEntity() {
    }

    public ProductInfoEntity(String serialId, String productName, String productDescription, Date serialDate) {
        this.serialId = serialId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.serialDate = serialDate;
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ProductInfoEntity(String serialId, String productName, String productDescription,
                             @DateTimeFormat(pattern = "dd/MM/yyyy") String serialDate) {
        this.serialId = serialId;
        this.productName = productName;
        this.productDescription = productDescription;
        try {
            this.serialDate = new Date(sdf.parse(serialDate).getTime());
        } catch (ParseException ignored) {
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Date getSerialDate() {
        return serialDate;
    }

    public void setSerialDate(Date serialDate) {
        this.serialDate = serialDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfoEntity that = (ProductInfoEntity) o;
        return id == that.id &&
                Objects.equals(serialId, that.serialId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productDescription, that.productDescription) &&
                Objects.equals(serialDate, that.serialDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialId, productName, productDescription, serialDate);
    }

    @Override
    public String toString() {
        return "ProductInfoEntity{" +
                "id=" + id +
                ", serialId='" + serialId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", serialDate=" + serialDate +
                '}';
    }
}
