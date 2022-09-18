package com.wang.gulimall;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class GulimallThirdPartyApplicationTests {
    @Resource
    OSSClient ossClient;
    @Test
    public void contextLoads() throws FileNotFoundException {
        InputStream inputStream=new FileInputStream("C:\\Users\\15347\\Desktop\\1185187093a4db59d2086dd74498d33f.jpg");
        ossClient.putObject("wangshenzhen","bug3.jpg",inputStream);
        System.out.println("上传成功！");



    }


}
