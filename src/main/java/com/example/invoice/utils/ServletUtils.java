package com.example.invoice.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname ServletUtils
 * @Description TODO
 * @Date 2022/3/28 15:24
 * @Author by fuxf
 */
public class ServletUtils {
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = getRequestAttributes();
        return requestAttributes.getRequest();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) requestAttributes;
    }

    public static Integer getParameterToInt(String parameterName, Integer defaultValue) {
        HttpServletRequest request = getRequest();
        String strValue = request.getParameter(parameterName);
        Integer intValue = StringUtils.hasText(strValue) ? Integer.valueOf(strValue) : defaultValue;
        //Convert.toInt(strValue, defaultValue);
        return intValue;
    }

    public static Integer getParameterToInt(String parameterName) {
        return getParameterToInt(parameterName, null);
    }

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
    }
}
