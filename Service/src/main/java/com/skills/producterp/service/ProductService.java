package com.skills.producterp.service;

import com.skills.producterp.dto.ProductDTO;
import com.skills.producterp.entity.ProductEntity;

import java.util.List;

/**
 * Created by chetanlo on 8/10/2016.
 */
public interface ProductService {
    String addProduct(ProductDTO productDTO);
    ProductDTO getProductDetailsById(Long productId);
    public String updateProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProductDetails();
}
