package com.lwy.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RefreshScope
@RequestMapping("/provider")
public class ItemController {

    @Value("${pattern.dateFormat}")
    private String pattern;

    @GetMapping("/now")
    public String now(){
        System.out.println(pattern);
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取商品的信息
     *
     * @param id
     * @return
     */
    @GetMapping("/item/{id}")
    public String getInfo(@PathVariable(name = "id") String id,@RequestHeader(value = "Truth",required = false) String truth) {
        String itemInfo = "SN:" + id;

        System.out.println("provider!!!!");
        System.out.println("truth = " + truth);
        return itemInfo;
    }

}
