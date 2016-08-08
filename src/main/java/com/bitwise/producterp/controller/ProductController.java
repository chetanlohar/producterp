package com.bitwise.producterp.controller;

import com.bitwise.producterp.core.ServiceUrls;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = ServiceUrls.GET_ALL,method = RequestMethod.GET)
    public ResponseEntity<List<String>> getProductDetails(){
        System.out.println("in getProductDetails..........=====>>>>");
        String str = "{\"ID\":\"2800\"}";
        List<String> l = new ArrayList<String>();
        l.add("Ford Fiesta");
        return new ResponseEntity<List<String>>(l,HttpStatus.OK);
    }





}
