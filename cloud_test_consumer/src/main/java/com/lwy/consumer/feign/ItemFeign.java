package com.lwy.consumer.feign;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


 /*指定注解 标识 该类为Feign接口
         name 指定要调用的服务名(目前随便填)
         url 指定要调用的服务（provider）的ip和端口*/
//@FeignClient(name="provider",url = "127.0.0.1:8081")
@FeignClient(name="provider")
public interface ItemFeign {

    /**
     * 根据用户ID 获取用户名
     * @param id
     * @return
     */
    @GetMapping("/provider/item/{id}")
    //该接口中的方法 和 被调用方法的controller中保持一致（即是应当声明一个接口的方法 和 controller一致）
    String getItemInfo(@PathVariable(name="id") String id);


}
