package com.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.plus.entity.MockUrl;
import com.plus.mapper.MockUrlMapper;
import com.plus.service.IMockUrlService;
import com.plus.dto.MockUrlDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.plus.common.Condition;
import com.plus.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * mock表 服务实现类
 *
 * @author AI
 * @since 2022-11-16
 */
@Service
@AllArgsConstructor
public class MockUrlServiceImpl implements IMockUrlService {

    protected MockUrlMapper mockUrlMapper;

    @Override
    public String getOne(HttpServletRequest request) {
        LambdaQueryWrapper<MockUrl> lqw = new LambdaQueryWrapper<>();
        String path = request.getRequestURI();
        String method = request.getMethod();
        String code = null;

        if (StrUtil.isNotBlank(request.getHeader("code"))) {
            code = request.getHeader("code");
        }

        lqw.eq(MockUrl::getUrl, path);
        lqw.eq(MockUrl::getRequestMethod, method);
        lqw.eq(StrUtil.isNotBlank(request.getHeader("code")), MockUrl::getUrlHead, code);

        MockUrl body = mockUrlMapper.selectOne(lqw);
        if (body == null){
            String message = "路径:" + path + ", 方法:" + method + ",不存在mock信息，请确认";
            String messageCode =  "路径:" + path + ",方法:" + method + ",请求头code:" + code  +",不存在mock信息，请确认";

            if (code == null){
                return "{\n" +
                        "    \"code\":\"500\",\n" +
                        "    \"message\":\" "+  message + " \"\n" +
                        "}";
            }else {
                return "{\n" +
                        "    \"code\":\"500\",\n" +
                        "    \"message\":\" "+  messageCode + " \"\n" +
                        "}";
            }
        }
        return body.getUrlBody();
    }
}
