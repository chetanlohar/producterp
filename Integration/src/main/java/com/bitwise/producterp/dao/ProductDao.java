package com.bitwise.producterp.dao;

import com.bitwise.producterp.entity.ProductEntity;

/**
 * Created by chetanlo on 8/10/2016.
 */
public interface ProductDao {

    public String addProduct(ProductEntity productEntity);
    public ProductEntity getProductDetails(Long productId);
    public String updateProduct(ProductEntity productEntity);

}
