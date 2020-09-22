package com.project.tan.controller;

import com.project.tan.common.enums.EnumBase;
import com.project.tan.common.util.EnumBaseUtil;
import com.project.tan.common.util.Result;
import com.project.tan.entity.dto.EnumListRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(description = "枚举值列表接口")
@Slf4j
@RestController
public class EnumController {

    /**
     * 根据入参获取枚举值MAP
     *
     * @param request 枚举类名
     * @return 枚举值MAP
     */
    @ApiOperation(value = "枚举列表")
    @RequestMapping(value = "/enum/list", method = RequestMethod.POST)
    public Result<Map<String, Map<String, String>>> enumList(@RequestBody EnumListRequest request) {
        Map<String, Map<String, String>> enumMapList = new HashMap<>();
        request.getEnumList().forEach(n -> {
            try {
                String pack = EnumBase.class.getPackage().getName();
                Class enumClass = Class.forName(pack + "." + n);
                enumMapList.put(n, EnumBaseUtil.getEnumMapByClass(enumClass));
            } catch (ClassNotFoundException e) {
                log.error("enumList:{} error", n);
            }
        });
        return Result.successData(enumMapList);
    }
}
