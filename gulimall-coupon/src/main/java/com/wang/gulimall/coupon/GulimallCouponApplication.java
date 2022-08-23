package com.wang.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1.如何使用nacos作为配置中心
 * 1）导入依赖
 * <dependency>
 * <groupId>com.alibaba.cloud</groupId>
 * <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 * </dependency>
 * 2）创建bootstrap.properties文件
 *  spring.application.name=gulimall-coupon
 * spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 *
 * 3.给配置中心添加当前应用名.properties(Data ID:gulimall-coupon.properties)
 *  eg:gulimall-coupon.properties
 *  4.给应用名.properties添加各种配置
 *  5.动态获取配置：
 *  @RefreshScope:动态获取并刷新配置
 *  @Value("${coupon.user.name}")
 *  如果配置中心和当前文件中都配置了 优先使用配置中心的
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
