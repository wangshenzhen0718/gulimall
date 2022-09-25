package com.wang.gulimall.product;

import com.wang.gulimall.product.service.BrandService;
import com.wang.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {
    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;

    @Test
    public void testFile2() {
        Long[] path = categoryService.findPath(225L);
        System.out.println(Arrays.asList(path));


    }

}
