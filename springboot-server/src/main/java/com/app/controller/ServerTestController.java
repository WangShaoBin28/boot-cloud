package com.app.controller;

import com.app.feign.Server1Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.app.controller
 * @ClassName ServerTestController
 * @Author shaobin.wang
 * @Date 2019/07/04 16:50
 * @Version 1.0
 * @Description:
 **/

@RestController
public class ServerTestController {

    @Autowired
    private Server1Feign server1Feign;

    @GetMapping("/helloServer")
    public String helloServer() {

        return "helloServer";
    }

    @GetMapping("/helloServer1")
    public String helloServer1() {

        return server1Feign.helloServer1();
    }


}
