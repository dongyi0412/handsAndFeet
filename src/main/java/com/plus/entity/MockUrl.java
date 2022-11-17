package com.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.plus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * mock表实体类
 *
 * @author AI
 * @since 2022-11-16
 */
@Data
@ApiModel(value = "MockUrl对象", description = "mock表")
@TableName("mock_url")
public class MockUrl {

    private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
    /**
     * mock路径
     */
  @ApiModelProperty(value = "mock路径")
  private String url;
    /**
     * 名字
     */
  @ApiModelProperty(value = "名字")
  private String urlName;
    /**
     * 请求头
     */
  @ApiModelProperty(value = "请求头")
  private String urlHead;
    /**
     * 消息体
     */
  @ApiModelProperty(value = "消息体")
  private String urlBody;
    /**
     * 消息返回延迟时间
     */
  @ApiModelProperty(value = "消息返回延迟时间")
  private String sleepTime;
    /**
     * 描述
     */
  @ApiModelProperty(value = "描述")
  private String description;
    /**
     * 分组
     */
  @ApiModelProperty(value = "分组")
  private String isUserGroup;
    /**
     * 请求方式
     */
  @ApiModelProperty(value = "请求方式")
  private String requestMethod;
    /**
     * 创建人
     */
  @ApiModelProperty(value = "创建人")
  private String author;
    /**
     * 是否开启，1开启，2不开启
     */
  @ApiModelProperty(value = "是否开启，1开启，2不开启")
  private String isShow;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;


}
