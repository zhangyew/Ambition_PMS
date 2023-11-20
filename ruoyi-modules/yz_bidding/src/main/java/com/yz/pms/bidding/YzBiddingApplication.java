package com.yz.pms;


import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class YzBiddingApplication {
    public static void main(String[] args) {
        SpringApplication.run(YzBiddingApplication.class);
        System.out.println("(♥◠‿◠)ﾉﾞ  招投标模块启动   ლ(´ڡ`ლ)");

    }
}
