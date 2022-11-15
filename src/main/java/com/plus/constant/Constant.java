package com.plus.constant;

/**
 * @Description:
 * @since 2019-11-03
 */
public interface Constant {
    String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    String PATTERN_DATE = "yyyy-MM-dd";
    String PATTERN_TIME = "HH:mm:ss";
    /**
     * Token键名
     */
    String TOKEN_KEY_NAME = "Authorization";
    /**
     * Token有效时间, 2小时, 60 * 60 * 2
     */
    Long AGENT_ADMIN_EFFECTIVE_TIME = 7200L;
    /**
     * 测试: 时间 5分钟, 60 * 5
     */
    Long TEST_TIME = 300L;
    /**
     * 测试: redis锁配置时间: 60秒
     */
    Long REDIS_LOCK_TIME = 60L;
    /**
     * 默认成功消息
     */
    String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认为空消息
     */
    String DEFAULT_NULL_MESSAGE = "暂无承载数据";


    char U_A = 'A';
    char L_A = 'a';
    char U_Z = 'Z';
    char L_Z = 'z';
}
