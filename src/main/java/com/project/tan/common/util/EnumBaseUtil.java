package com.project.tan.common.util;


import com.project.tan.common.enums.EnumBase;
import com.project.tan.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.EnumUtils.getEnumList;


public class EnumBaseUtil {


    /**
     * 根据枚举码获取枚举对象
     *
     * @param code
     * @param clz
     * @param <T>
     * @return
     */
    public static <T extends EnumBase> T getByCode(String code, Class<T> clz) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (T e : clz.getEnumConstants()) {
            if (StringUtils.equals(e.code(), code)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 根据枚举码获取枚举对象Map
     *
     * @param <T>
     * @return
     */
    public static <T extends EnumBase> Map<String, String> getEnumMapByClass(Class<T> clz) {
        Map<String, String> enumMap = new LinkedHashMap<>();
        for (T e : clz.getEnumConstants()) {
            enumMap.put(e.code(), e.message());
        }
        return enumMap;
    }

    /**
     * 获取枚举码
     * 枚举对象为空时，返回null
     *
     * @param enumBase
     * @return
     */
    public static String getCodeNullIfEmpty(EnumBase enumBase) {
        return getCodeDefaultIfEmpty(enumBase, null);
    }

    /**
     * 获取枚举码
     * 枚举对象为空时，返回空串
     *
     * @param enumBase
     * @return
     */
    public static String getCodeDefaultIfEmpty(EnumBase enumBase) {
        return getCodeDefaultIfEmpty(enumBase, StringUtils.EMPTY);
    }

    /**
     * 获取枚举码
     * 枚举对象为空时，返回默认值
     *
     * @param enumBase
     * @param defaultStr
     * @return
     */
    public static String getCodeDefaultIfEmpty(EnumBase enumBase, String defaultStr) {
        return null == enumBase ? defaultStr : enumBase.code();
    }

    public static <E extends Enum<E>> String getCodeByMessage(Class<E> enumClass, String message) {
        List<E> enumList = getEnumList(enumClass);
        for (E num : enumList) {
            EnumBase enumBase = (EnumBase) num;
            if (enumBase.message().equals(message.trim())) {
                return enumBase.code();
            }
        }
        throw new BizException("没有 '" + message + "' 类型");
    }

}
