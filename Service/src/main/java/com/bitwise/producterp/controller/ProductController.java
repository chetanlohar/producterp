package com.bitwise.producterp.controller;

import com.bitwise.producterp.dto.ProductDTO;
import com.bitwise.producterp.entity.ProductEntity;
import com.bitwise.producterp.core.ServiceUrls;
import com.bitwise.producterp.service.ProductService;
import com.bitwise.producterp.utility.ErpLogger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ProductService productService;

    @RequestMapping(value = ServiceUrls.GET_ALL,method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<ProductDTO>> getProductDetails(){
        erpLogger.info("ProductController --> Get Product Details");
        return new ResponseEntity<>(productService.getAllProductDetails(),HttpStatus.OK);
    }

    @RequestMapping(value = ServiceUrls.ADD, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<String> addProduct(@RequestBody ProductDTO product){
        erpLogger.info("=================>>>>>>>>>>>>>>>>>"+ product.toString());
        String message = productService.addProduct(product);
        return new ResponseEntity<>("{\"message\":\""+message+"\"}",HttpStatus.OK);
    }

    @RequestMapping(value = ServiceUrls.GET+"{productId}")
    public @ResponseBody ResponseEntity<ProductDTO> getProductDetailsById(@PathVariable("productId") Long productId){
        erpLogger.info("product id: "+productId);
        String message = "product fetch Successfully";
        ProductDTO productDTO = productService.getProductDetailsById(productId);
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    @RequestMapping(value = ServiceUrls.UPDATE, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<String> updateProduct(@RequestBody ProductDTO product){
        erpLogger.info("=================>>>>>>>>>>>>>>>>>"+ product.toString());
        String message = productService.updateProduct(product);
        return new ResponseEntity<>("{\"message\":\""+message+"\"}",HttpStatus.OK);
    }
}
