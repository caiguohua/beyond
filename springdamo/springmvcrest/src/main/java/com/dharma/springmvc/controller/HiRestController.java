package com.dharma.springmvc.controller;

import com.dharma.springmvc.domain.Message;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiRestController {

    //@RequestMapping("/")
//    @RequestMapping(method = RequestMethod.GET,value = "/")
//    @GetMapping("/")
    /**
     * 三个等价
     */
//    public String welcome(){
//        return "welcome to RestTemplate Example";
//    }

//    @RequestMapping("/hi/{player}")
    @RequestMapping(method = RequestMethod.POST,value = "/hi/{player}")
    public Message message(@PathVariable String player){
        return new Message(player,"hello world");
    }
}
