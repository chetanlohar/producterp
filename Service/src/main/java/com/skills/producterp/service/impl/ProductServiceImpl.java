package com.skills.producterp.service.impl;

import com.skills.producterp.dao.ProductDao;
import com.skills.producterp.dto.ProductDTO;
import com.skills.producterp.entity.ProductEntity;
import com.skills.producterp.service.ProductService;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chetanlo on 8/10/2016.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Override
    @Transactional
    public String addProduct(ProductDTO productDTO) {
        ProductEntity productEntity = dozerBeanMapper.map(productDTO,ProductEntity.class);  //new ProductEntity(productDTO.getProductId(),productDTO.getProductName());
        return productDao.addProduct(productEntity);
    }

    @Override
    public ProductDTO getProductDetailsById(Long productId) {
        return dozerBeanMapper.map(productDao.getProductDetails(productId),ProductDTO.class);
    }

    @Override
    @Transactional
    public String updateProduct(ProductDTO productDTO) {
        return productDao.updateProduct(dozerBeanMapper.map(productDTO,ProductEntity.class));
    }

    @Override
    public List<ProductDTO> getAllProductDetails() {
        List<ProductEntity> p =productDao.getAllProductDetails();
        List<ProductDTO> pDto = new ArrayList<>();
        for(ProductEntity product:p)
            pDto.add(dozerBeanMapper.map(product,ProductDTO.class));
        return pDto;
    }
}
