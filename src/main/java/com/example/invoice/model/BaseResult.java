package com.example.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname BaseResult
 * @Description TODO
 * @Date 2022/3/28 14:51
 * @Author by fuxf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> {
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_UNAUTHORIZED = 401;
    public static final int CODE_FORBIDDEN = 403;
    public static final int CODE_ERROR = 500;

    public static final String MSG_SUCCESS = "操作成功";
    public static final String MSG_FAILED = "操作失败";
    public static final String MSG_NOT_PERMISSION = "用户权限不足";
    public static final String MSG_UNAUTHORIZED = "用户未登录或身份已过期";

    private int code;
    private String msg;
    private T data;

    public static <T> BaseResult success(int code, T data) {
        return new BaseResult(code, MSG_SUCCESS, data);
    }

    public static <T> BaseResult success(T data) {
        return success(CODE_SUCCESS, data);
    }

    public static BaseResult success() {
        return success(CODE_SUCCESS, null);
    }

    public static BaseResult error(int code, String msg) {
        return new BaseResult(code, msg, null);
    }

    public static BaseResult error(String msg) {
        return error(CODE_ERROR, msg);
    }

    public static BaseResult error() {
        return new BaseResult(CODE_ERROR, MSG_FAILED, null);
    }


}
