package com.bitwise.producterp.controller;

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
    public @ResponseBody  ResponseEntity<List<String>> getProductDetails(){
        erpLogger.info("ProductController --> Get Product Details");
        String str = "{\"ID\":\"2800\"}";
        List<String> l = new ArrayList<String>();
        l.add("Ford Fiesta");
        l.add("1.6 SXI Petrol");
        return new ResponseEntity<List<String>>(l,HttpStatus.OK);
    }







}
