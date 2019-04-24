package com.springcloud.cgh.controller;

import com.springcloud.cgh.bean.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    private static final Map<Integer, Product> productData = new HashMap<Integer, Product>() {
        private static final long serialVersionUID = -3970206781360313502L;

        {
            put(1, new Product(1, "iPhoneX", 9999.9));
            put(2, new Product(2, "FindX", 4999.0));
            put(3, new Product(3, "Mi8", 2999.0));
        }

    };

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public Product getProductDetails(@PathVariable int productId) {
        System.out.println("Getting Product details for " + productId);

        Product product = productData.get(productId);
        if (product == null) {
            product = new Product(0, "N/A", 0.0);
        }
        return product;
    }

}
