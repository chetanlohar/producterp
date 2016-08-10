package com.bitwise.producterp.service.impl;

import com.bitwise.producterp.dao.ProductDao;
import com.bitwise.producterp.dto.ProductDTO;
import com.bitwise.producterp.entity.ProductEntity;
import com.bitwise.producterp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chetanlo on 8/10/2016.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public String addProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity(productDTO.getProductId(),productDTO.getProductName());
        return productDao.addProduct(productEntity);
    }

    @Override
    public ProductEntity getProductDetailsById(Long productId) {
        return productDao.getProductDetails(productId);
    }

    @Override
    @Transactional
    public String updateProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity(productDTO.getProductId(),productDTO.getProductName());
        return productDao.updateProduct(productEntity);
    }
}
