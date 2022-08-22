package com.wang.gulimall.product.dao;

import com.wang.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author wangshenzhen
 * @email 153474100@qq.com
 * @date 2022-08-21 23:04:12
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
