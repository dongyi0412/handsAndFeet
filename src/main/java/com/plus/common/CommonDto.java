package com.plus.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName ModelRo.java
 * @Description 功能描述：
 */
@Data
public class CommonDto {

    /**
     * 页码
     */
    @ApiModelProperty(value = "页码，默认1")
    private Integer       pageNum  = 1;
    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量，默认10，最大50")
    private Integer       pageSize = 10;
    /**
     * 排序参数
     */
    @ApiModelProperty(value = "升序字段")
    private String        orderAsc;
    /**
     * 排序方式：asc/desc
     */
    @ApiModelProperty(value = "降序字段")
    private String        orderDesc;

    /**
     * 查询关键字
     */
    @ApiModelProperty(value = "查询关键字用来模糊匹配")
    private String        keywords;

    /**
     * 查询关键字字段
     */
    @ApiModelProperty(value = "查询关键字用来模糊匹配")
    private String        column;


    /**
     * 查询开始时间
     */
    @ApiModelProperty(value = "查询开始时间yyyy-MM-dd格式")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date          startTime;
    /**
     * 查询结束时间
     */
    @ApiModelProperty(value = "查询结束时间yyyy-MM-dd格式")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date          endTime;

}
