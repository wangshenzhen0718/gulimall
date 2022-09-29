package com.wang.common.constant;

import lombok.Getter;

public class ProductConstant {

    public enum AttrEnum{
        ATTR_TYPE_BASE(1,"基本属性"),ATTR_TYPE_SALE(0,"销售属性");

        @Getter
        private int code;
        @Getter
        private String msg;
        AttrEnum(int code,String msg){
            this.code=code;
            this.msg=msg;
        }


    }
}
