package com.plus.exception;

import lombok.Getter;


@Getter
public enum ErrorEnum   {
    OK(0, "成功", 1),
    FAIL(500,"系统异常，请联系对应开发"),

    // ----------------------- 系统级错误 -----------------------
    SYSTEM_ERROR(10001, "系统错误！"),
    SYSTEM_PARAM(10002, "参数异常"),
    //店铺错误
    SHOP_NULL(20001,"店铺不存在"),
    //订单
    ORDER_SENDER(30001,"发件人信息错误；请输入:'dxq 110' 格式"),
    ORDER_NULL(30002,"渠道订单不存在！！"),
    ORDER_SENDER_NULL(30003,"店铺没有指定姓名和电话，请输入发件人姓名和电话"),
    ORDER_SENDER_ERR(30004,"发件人信息格式错误 ，格式为：姓名,电话 （注意英语','）"),
    ORDER_ERR(30005,"下单失败"),
    ORDER_LAST_SEND_DAY_ERROR(30006,"最晚返货时间退出时间必须 >= 0 "),
    ORDER_SHOP_GOODS_NULL(30007,"不存在该商品"),
    //清关
    CSS_CLEARANCE_NULL(40001,"订单不存在，不能清关"),
    //渠道
    Channel_NULL(80001,"渠道不存在"),
    CHANNEL_AUTHORIZE_SHOP_NULL(80002 , "该渠道不存在'已授权'店铺,请手动授权或找开发帮忙"),
    CHANNEL_AUTHORIZE_NO(80003 , "'字节南波万'和'抖音保税'授权信息不能相同，必须手动授权,"),
    //订单物流
    ORDER_LOGISTIC_NULL(90001,"运单号为空"),

    //wms
    //出库单
    SHIPMENT_ORDER_NULL(50001,"WMS出库单不存在，请到erp确认是否下发"),
    //汇单
    Bill_OF_EXCHANGE_ERROR_NULL(100001,"汇单查询为空"),
    Bill_OF_EXCHANGE_ERROR_NUM(100002,"外部订单汇单数量存在多条，请查看"),
    //PDD
    PDD_ORDER_SN_ERROR(60001,"skuId必须为数字"),
    //CloudWareHouse
    CLOUD_HOUSE_NULL(70001,"云仓不存在，请确认")
    ;

    private int code;
    private String message;

    /**
     * app需要的状态
     */
    private int appResultStatus;

    ErrorEnum(int code, String message) {
        this(code, message, 0);
    }

    ErrorEnum(int code, String message, int appResultStatus) {
        this.code = code;
        this.message = message;
        this.appResultStatus = appResultStatus;
    }

}
