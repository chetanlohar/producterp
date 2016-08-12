package com.bitwise.producterp.dao;

import com.bitwise.producterp.entity.ProductEntity;

import java.util.List;

/**
 * Created by chetanlo on 8/10/2016.
 */
public interface ProductDao {

    public String addProduct(ProductEntity productEntity);
    public ProductEntity getProductDetails(Long productId);
    public String updateProduct(ProductEntity productEntity);
    public List<ProductEntity> getAllProductDetails();

}
