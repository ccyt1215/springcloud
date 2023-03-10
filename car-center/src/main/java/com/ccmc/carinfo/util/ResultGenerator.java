package com.ccmc.carinfo.util;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }
    public static Result genSuccessResult(Object data,String message) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }
    public static Result genSuccessResult(int code,Object data,String message) {
        return new Result()
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }

    public static Result genSuccessResult(int code,String message) {
        return new Result()
                .setCode(code)
                .setMessage(message);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
    public static Result genTokenExpiredResult(String message) {
        return new Result()
                .setCode(ResultCode.TOKEN_EXPIRED)
                .setMessage(message);
    }
    public static Result genReLoginResult(String message) {
        return new Result()
                .setCode(ResultCode.RELOGIN)
                .setMessage(message);
    }
}
