package com.plus.service;

import com.plus.entity.MockUrl;
import com.plus.dto.MockUrlDTO;
import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.servlet.http.HttpServletRequest;

/**
 * mock表 服务类
 *
 * @author AI
 * @since 2022-11-16
 */
public interface IMockUrlService  {
        String  getOne(HttpServletRequest request) ;
}
