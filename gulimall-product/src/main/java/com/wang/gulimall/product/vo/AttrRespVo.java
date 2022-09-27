package com.wang.gulimall.product.vo;

import com.wang.gulimall.product.entity.AttrEntity;
import lombok.Data;

@Data
public class AttrRespVo extends AttrEntity {
    private String catelogName;
    private String groupName;
}
