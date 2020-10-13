package com.mvcprime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvcprime.domain.Product;
import com.mvcprime.repository.ProductDao;

@Service
public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
    private List<Product> products;
    
    @Transactional
    public List<Product> getProducts() {
    	return productDao.getProductList(); 
    }	

    @Transactional
    public void increasePrice(int percentage) {
    	List<Product> products = productDao.getProductList();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                productDao.saveProduct(product);
            }
        }  
    }
	
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
