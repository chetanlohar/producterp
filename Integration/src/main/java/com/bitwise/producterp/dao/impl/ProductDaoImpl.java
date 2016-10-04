package com.bitwise.producterp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitwise.producterp.dao.AbstractJpaDao;
import com.bitwise.producterp.dao.ProductDao;
import com.bitwise.producterp.entity.CategoryEntity;
import com.bitwise.producterp.entity.ProductEntity;

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
        List<ProductEntity> products = findAll();
        for(ProductEntity p: products){
        	System.out.println("P: "+p.getProductName()+"=============>>>>>>>>>");
        	for(CategoryEntity c: p.getCategories())
        		System.out.println(c.getCategoryName());
        }
        return products;
    }
}
