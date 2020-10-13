package com.mvcprime.domain;

import java.util.List;

import com.mvcprime.repository.ProductDao;

public class PseudoDao implements ProductDao {

    private List<Product> productList;

    public PseudoDao(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void saveProduct(Product prod) {
    }

}
