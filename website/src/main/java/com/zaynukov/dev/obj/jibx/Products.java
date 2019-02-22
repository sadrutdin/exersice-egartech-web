package com.zaynukov.dev.obj.jibx;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<ProductItem> list;

    public List<ProductItem> getList() {
        return list;
    }

    public void setList(List<ProductItem> list) {
        this.list = list;
    }

    public static List<ProductItem> listFactory(){
        return new ArrayList<>();
    }

    public Products() {
    }

    public Products(List<ProductItem> list) {
        this.list = list;
    }
}
