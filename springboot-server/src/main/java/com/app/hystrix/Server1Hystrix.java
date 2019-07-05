package com.app.hystrix;

import com.app.feign.Server1Feign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * @Package com.app.feign
 * @ClassName Server2Feign
 * @Author shaobin.wang
 * @Date 2019/07/04 16:52
 * @Version 1.0
 * @Description:
 **/
@Component
public class Server1Hystrix implements Server1Feign {

    @Override
    public String helloServer1() {
        return "调用失败！";
    }

    /**
     * 方法simpleHystrixClientCall的回退方法，可以指定将hystrix执行失败异常传入到方法中
     * @param name 必须跟hiService参数一致
     * @param e 执行失败的异常对象，非必须
     */
    public String hiError(String name, Throwable e) {
        System.out.println("错误信息："+e.getMessage());
        return "hi,"+name+",sorry,error!";
    }
}
