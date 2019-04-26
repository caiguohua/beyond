package com.zhp.user.zhpuser;

import com.zhp.user.zhpuser.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "product" ,url = "http://localhost:8012")
public interface ProductClient {

    @GetMapping(value = "/product/id/{id}",produces = "application/json")
    Product getProductById(@PathVariable("id") Integer id);

    @PostMapping(value = "/product",produces = "application/json")
    Product createProduct(@RequestBody Product product);

    @PutMapping(value = "/product",produces = "application/json")
    Product updateProduct(@RequestBody Product product);

    @DeleteMapping(value = "/product/{id}",produces = "application/json")
    Product deleteProduct(@PathVariable("id") Integer id);
}
