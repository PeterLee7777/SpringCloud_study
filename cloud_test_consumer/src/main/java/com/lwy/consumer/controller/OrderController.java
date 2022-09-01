package com.lwy.consumer.controller;

import com.lwy.consumer.feign.ItemFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/consumer")
public class OrderController {
    @Autowired
    private ItemFeign itemFeign;

    @Value("${jdbc.url}")
    private String url;

    @GetMapping("/doOrder")
    public String doOrder() {
        //1.模拟远程调用获取到到商品信息
        String info = itemFeign.getItemInfo("1");
        //2.模拟下单
        System.out.println("张三:下单成功,商品信息为："+info);
        //4.模拟配置信息获取 打印
        System.out.println("值为：" + url);
        //3.模拟返回成功信息
        return info;
    }


}
