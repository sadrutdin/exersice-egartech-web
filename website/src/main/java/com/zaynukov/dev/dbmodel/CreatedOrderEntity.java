package com.zaynukov.dev.dbmodel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "created_orders", schema = "public", catalog = "exercise")
public class CreatedOrderEntity {
    private int id;
    private String customerName;
    private String customerAddress;
    private long sum;
    private Date createdDatetime;
    private List<CreatedOrderDetailsEntity> details;

    public CreatedOrderEntity() {
    }

    public CreatedOrderEntity(String customerName, String customerAddress, long sum, Date createdDatetime, List<CreatedOrderDetailsEntity> details) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.sum = sum;
        this.createdDatetime = createdDatetime;
        this.details = details;
    }

    public CreatedOrderEntity(String customerName, String customerAddress, long sum, Date createdDatetime, Iterable<CreatedOrderDetailsEntity> iterDetails) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.sum = sum;
        this.createdDatetime = createdDatetime;

        List<CreatedOrderDetailsEntity> t = new ArrayList<>();
        for (CreatedOrderDetailsEntity d : iterDetails) t.add(d);
        if (!t.isEmpty()) details = t;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
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

    @OneToMany(mappedBy = "order", targetEntity = CreatedOrderDetailsEntity.class,
            cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    public List<CreatedOrderDetailsEntity> getDetails() {
        return details;
    }

    public void setDetails(List<CreatedOrderDetailsEntity> details) {
        this.details = details;
    }
}
