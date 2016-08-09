package com.bitwise.producterp.controller;

import com.bitwise.producterp.entity.ProductEntity;
import com.bitwise.producterp.core.ServiceUrls;
import com.bitwise.producterp.utility.ErpLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chetanlo on 8/4/2016.
 */
@RestController
@RequestMapping(value = ServiceUrls.PRODUCT)
public class ProductController {

    ErpLogger erpLogger = new ErpLogger(ProductController.class);

    @RequestMapping(value = ServiceUrls.GET_ALL,method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<ProductEntity>> getProductDetails(){
        erpLogger.info("ProductController --> Get Product Details");
        String str = "{\"ID\":\"2800\"}";
        List<ProductEntity> l = new ArrayList<ProductEntity>();
        l.add(new ProductEntity(1,"Samsung"));
        l.add(new ProductEntity(2,"Apple"));
        l.add(new ProductEntity(3,"Sony"));
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    @RequestMapping(value = ServiceUrls.ADD, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<String> addProduct(@RequestBody ProductEntity product){
        erpLogger.info("=================>>>>>>>>>>>>>>>>>"+ product.toString());
        return new ResponseEntity<>("{\"message\":\"Product Added Successfully\"}",HttpStatus.OK);
    }







}
