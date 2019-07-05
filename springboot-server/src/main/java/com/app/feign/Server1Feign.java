package com.app.feign;

import com.app.hystrix.Server1Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Package com.app.feign
 * @ClassName Server2Feign
 * @Author shaobin.wang
 * @Date 2019/07/04 16:52
 * @Version 1.0
 * @Description:
 **/
@FeignClient(name = "springboot-server1", fallback = Server1Hystrix.class)
public interface Server1Feign {


    @GetMapping("/helloServer1")
    String helloServer1();

}
