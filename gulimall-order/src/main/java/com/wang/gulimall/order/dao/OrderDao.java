package com.wang.gulimall.order.dao;

import com.wang.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author wangshenzhen
 * @email 153474100@qq.com
 * @date 2022-08-22 14:37:11
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
