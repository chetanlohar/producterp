package com.bitwise.producterp.controller;

import com.bitwise.producterp.core.ServiceUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chetanlo on 8/4/2016.
 */
@Controller
@RequestMapping(value = ServiceUrls.PRODUCT)
public class IndexController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String productDetails(){
        System.out.println("hi.... in ProductController... ");
        return "product/product";
    }
}
