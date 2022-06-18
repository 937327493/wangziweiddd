package com.wzw.wangziwei.ddd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.wzw.wangziwei.ddd"})
@MapperScan("com.wzw.wangziwei.ddd.infrastructure.repository.mybatis.mapper")
public class WangziweidddApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(WangziweidddApplication.class, args);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}
