package com.bitwise.producterp.dao.impl;

import com.bitwise.producterp.dao.AbstractJpaDao;
import com.bitwise.producterp.dao.ProductDao;
import com.bitwise.producterp.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chetanlo on 8/10/2016.
 */

@Repository
public class ProductDaoImpl extends AbstractJpaDao<ProductEntity> implements ProductDao{

    @Override
    public String addProduct(ProductEntity productEntity) {
        persist(productEntity);
        return "Product Added Successfully";
    }

    @Override
    public ProductEntity getProductDetails(Long productId) {
        setClazz(ProductEntity.class);
        return find(productId);
    }

    @Override
    public String updateProduct(ProductEntity productEntity) {
        merge(productEntity);
        return "Product Updated Successfully";
    }

    @Override
    public List<ProductEntity> getAllProductDetails() {
        setClazz(ProductEntity.class);
        return findAll();
    }
}
