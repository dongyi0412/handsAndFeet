package com.plus.base;

import lombok.Getter;

@Getter
public enum DataType {

    STRING(1, "操作成功，数据格式是：字符串"),
    PICTURE(2, "操作成功，数据格式是：图片"),
    TABLE(3, "操作成功，数据格式是：表格"),
    ;

    private int code;
    private String desc;

    DataType(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
