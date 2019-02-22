package com.zaynukov.dev.dbmodel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "created_orders", schema = "public", catalog = "exercise")
public class CreatedOrderEntity {
    private long id;
    private String customerName;
    private String customerAddress;
    private long sum;
    private Timestamp createdDatetime;
    private CreatedOrderDetailsEntity details;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_address")
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Basic
    @Column(name = "sum")
    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "created_datetime")
    public Timestamp getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Timestamp createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatedOrderEntity that = (CreatedOrderEntity) o;
        return id == that.id &&
                sum == that.sum &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(customerAddress, that.customerAddress) &&
                Objects.equals(createdDatetime, that.createdDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, customerAddress, sum, createdDatetime);
    }

    @OneToOne
    @JoinColumn(name = "details", referencedColumnName = "id")
    public CreatedOrderDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(CreatedOrderDetailsEntity details) {
        this.details = details;
    }

}