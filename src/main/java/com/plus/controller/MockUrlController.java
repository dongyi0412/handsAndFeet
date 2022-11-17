package com.plus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.plus.common.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.plus.service.IMockUrlService;


import javax.servlet.http.HttpServletRequest;

/**
 * mock表 控制器
 *
 * @author AI
 * @since 2022-11-16
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@Api(description = "mock表相关接口")
public class MockUrlController {

    private IMockUrlService mockUrlService;

    /**
     * 详情
     */
    @GetMapping("/**")
    @ApiOperation(value = "详情", notes = "传入mockUrl")
    public String detail(HttpServletRequest request,
                         @RequestBody String requestBody,
                         @RequestParam(value = "code",required = false)Integer code) {
        String body = requestBody;

        return mockUrlService.getOne(request);
    }
}
