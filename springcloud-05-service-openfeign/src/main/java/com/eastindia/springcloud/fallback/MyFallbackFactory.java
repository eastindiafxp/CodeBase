package com.eastindia.springcloud.fallback;

import com.eastindia.springcloud.service.HelloService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallbackFactory implements FallbackFactory<HelloService> {

    @Override
    public HelloService create(Throwable cause) {
        return new HelloService() {

            /**
             * 服务调用不通的时候调用此方法中的内容
             * @return
             */
            @Override
            public String hello() {
                return cause.getMessage();
            }
        };
    }

}
