package com.zhp.user.zhpuser;

import com.zhp.user.zhpuser.bean.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "type" ,url = "http://localhost:8012")
public interface TypeClient {

    @GetMapping(value = "/type/typeid/{typeId}",produces = "application/json")
    Type getTypeById(@PathVariable("typeId") Integer typeId);

    @PostMapping(value = "/type",produces = "application/json")
    Type createType(@RequestBody Type type);

    @PutMapping(value = "/type",produces = "application/json")
    Type updateType(@RequestBody Type type);

    @DeleteMapping(value = "/type/{typeId}",produces = "application/json")
    Type deleteType(@PathVariable("typeId") Integer typeId);
}
