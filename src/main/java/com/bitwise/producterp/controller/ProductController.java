package com.bitwise.producterp.controller;

import com.bitwise.entity.ProductEntity;
import com.bitwise.producterp.core.ServiceUrls;
import com.bitwise.utility.ErpLogger;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public @ResponseBody  ResponseEntity<List<ProductEntity>> getProductDetails(){
        erpLogger.info("ProductController --> Get Product Details");
        String str = "{\"ID\":\"2800\"}";
        List<ProductEntity> l = new ArrayList<ProductEntity>();
        l.add(new ProductEntity(1,"Samsung"));
        l.add(new ProductEntity(2,"Apple"));
        l.add(new ProductEntity(3,"Sony"));
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    @RequestMapping(value = ServiceUrls.ADD, method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ResponseEntity<String> addProduct(ProductEntity product){
        erpLogger.info(product.toString());
        return new ResponseEntity<>("=====>>>>>>> Product '"+product.getProductName()+"' added Successfully"
                ,HttpStatus.OK);
    }







}
