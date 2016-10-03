package com.skills.producterp.dao;

import java.util.List;

import com.skills.producterp.entity.ProductEntity;

/**
 * Created by chetanlo on 8/10/2016.
 */
public interface ProductDao {

    public String addProduct(ProductEntity productEntity);
    public ProductEntity getProductDetails(Long productId);
    public String updateProduct(ProductEntity productEntity);
    public List<ProductEntity> getAllProductDetails();

}
