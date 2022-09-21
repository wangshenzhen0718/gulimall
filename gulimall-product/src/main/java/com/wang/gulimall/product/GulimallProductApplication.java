package com.wang.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GulimallProductApplication {
    /*
    1、JSR303
        1）、给Bean添加校验注解:javax.validation.constraints，并定义自己的message提示
        2)、开启校验功能@valid
            效果:校验错误以后会有默认的响应;
        3)、给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
    2 、分组校验（多场景的复杂校验)
        1)、@NotBLanke(message = "品牌名必须提交" , groups = fAddGroup.class,UpdateGroup.class给校验注解标注什么情况需要进行校验
        2) 、@Validated( {AddGroup.cLass})
        3)、默认没有指定分组的校验注解@NotBLank，在分组校验情况gVaLidated({AddGroup.class})下不
    3、自定义校验
        1)、编写一个自定义的校验注解
        2)、编写一个自定义的校验器constraintValidator
        3)、关联自定义的校验器和自定义的校验注解
        */
    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
