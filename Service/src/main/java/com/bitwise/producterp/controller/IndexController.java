package com.bitwise.producterp.controller;

import com.bitwise.producterp.core.ServiceUrls;
import com.bitwise.producterp.utility.ErpLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chetanlo on 8/4/2016.
 */
@Controller
@RequestMapping(value = ServiceUrls.HOME)
public class IndexController {
    ErpLogger erpLogger = new ErpLogger(IndexController.class);
    @RequestMapping(value={"","/"},method = RequestMethod.GET)
    public String showHome(){
        erpLogger.info("hi.... in ProductController... ");
        return "home";
    }
}
