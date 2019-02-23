package com.zaynukov.dev.dbmodel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "created_orders_details", schema = "public", catalog = "exercise")
public class CreatedOrderDetailsEntity {
    private long id;
    private String serialId;
    private Integer count;
    private CreatedOrderEntity order;

    public CreatedOrderDetailsEntity() {
    }

    public CreatedOrderDetailsEntity(String serialId, Integer count) {
        this.serialId = serialId;
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "serial_id")
    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    public CreatedOrderEntity getOrder() {
        return order;
    }

    public void setOrder(CreatedOrderEntity orderEntity) {
        this.order = orderEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatedOrderDetailsEntity that = (CreatedOrderDetailsEntity) o;
        return id == that.id &&
                Objects.equals(serialId, that.serialId) &&
                Objects.equals(count, that.count) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialId, count, order);
    }

    @Override
    public String toString() {
        return "CreatedOrderDetailsEntity{" +
                "id=" + id +
                ", serialId='" + serialId + '\'' +
                ", count=" + count +
                ", orderId=" + order.toString() +
                '}';
    }
}
