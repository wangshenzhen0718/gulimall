package com.wang.gulimall.member.dao;

import com.wang.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author wangshenzhen
 * @email 153474100@qq.com
 * @date 2022-08-22 14:27:00
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
