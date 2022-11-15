package com.plus.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * @Description:
 * @author: AI
 * @date: 2019/11/17
 */
@Slf4j
public class BeanCopyUtils {
    public static <T> T copy(Object source, Class<T> clazz) {
        T to = null;
        try {
            to = clazz.newInstance();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (to == null) {
            return null;
        }
        BeanUtils.copyProperties(source, to);
        return to;
    }
}
