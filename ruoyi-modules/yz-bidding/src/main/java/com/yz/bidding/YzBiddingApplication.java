package com.yz.bidding;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 招投标模块
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class YzBiddingApplication {

    public static void main(String[] args) {
        SpringApplication.run(YzBiddingApplication.class, args);
        System.out.println("***** 招投标模板启动！！！ *****");
    }

}
