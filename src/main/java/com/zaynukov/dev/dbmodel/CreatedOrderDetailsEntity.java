package com.zaynukov.dev.dbmodel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "created_orders_details", schema = "public", catalog = "exercise")
public class CreatedOrderDetailsEntity {
    private long id;
    private String serialId;
    private Integer count;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatedOrderDetailsEntity that = (CreatedOrderDetailsEntity) o;
        return id == that.id &&
                Objects.equals(serialId, that.serialId) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialId, count);
    }
}
