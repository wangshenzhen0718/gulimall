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
 * spring.application.name=gulimall-coupon
 * spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 * <p>
 * 3)给配置中心添加当前应用名.properties(Data ID:gulimall-coupon.properties)
 * eg:gulimall-coupon.properties
 * 4)给应用名.properties添加各种配置
 * 5)动态获取配置：
 *
 * @RefreshScope:动态获取并刷新配置
 * @Value("${coupon.user.name}") 如果配置中心和当前文件中都配置了 优先使用配置中心的
 * <p>
 * 2、细节
 * 1)命名空间:配置隔离;
 * 默认:public(保留空间);默认新增的所有配置都在public空间。
 * 1、开发,测试,生产:利用命名空间来做环境隔离。
 * 注意:在bootstrap.properties;配置上，需要使用哪个命名空间下的配置，
 * spring.cloud.nacos.config.namespace=9de62e44-cd2a-4a82-bf5c-95878bd5e871
 * 2、每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
 * 2) 配置集
 * 所有配置的集合
 * 3) 配置集ID
 * Data ID-文件名
 * 4) 、配置分组
 *
 * 3、同时加载多个配置集
 * 1)、微服务任何配置信息,任何配置文件都可以放在配置中心中
 * 2)、只需要在bootstrap.properties说明加载配置中心中哪些配置文件即可
 * 3) 、 @Value,@ConfigurationProperties。 o o
 * 以前SpringBoot任何方法从配置文件中获取值,都能使用。配置中心有的优先使用配置中心中的
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
