package com.skills.producterp.dao.impl;

import com.skills.producterp.dao.AbstractJpaDao;
import com.skills.producterp.dao.ProductDao;
import com.skills.producterp.entity.ProductCategoryEntity;
import com.skills.producterp.entity.ProductEntity;

import org.springframework.stereotype.Repository;

import java.util.Iterator;
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
        List<ProductEntity> products = findAll();
        for(ProductEntity p: products) {
            System.out.println("ProductName: "+p.getProductName() + " : =============>>>>>>>>>>>>");
            for(ProductCategoryEntity pc: p.getProductCategoryEntityList())
                System.out.println(pc.getProductEntity().getProductName()+":"+pc.getCategoryEntity().getCategoryName());
        }
        return products;
    }
}
