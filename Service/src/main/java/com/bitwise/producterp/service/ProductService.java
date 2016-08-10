package com.bitwise.producterp.service;

import com.bitwise.producterp.dto.ProductDTO;
import com.bitwise.producterp.entity.ProductEntity;

/**
 * Created by chetanlo on 8/10/2016.
 */
public interface ProductService {
    String addProduct(ProductDTO productDTO);
    ProductEntity getProductDetailsById(Long productId);
    public String updateProduct(ProductDTO productDTO);
}
