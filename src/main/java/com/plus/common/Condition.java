package com.plus.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页工具
 */
public class Condition {

    /**
     * 转化成mybatis plus中的Page
     *
     * @param commonDto
     * @param <T>
     * @return
     */
    public static <T> IPage<T> getPage(CommonDto commonDto) {
        Page<T> page = new Page<>(commonDto.getPageNum(), commonDto.getPageSize());
        return page;
    }

    /**
     * 获取mybatis plus中的QueryWrapper
     *
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
        return new QueryWrapper<>(entity);
    }

}
