package com.mvcprime.repository;

import java.util.List;

import com.mvcprime.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}