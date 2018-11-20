package com.wl.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回格式
 *
 * @Author LI·NING
 * @Description
 * @Date Create in 2017/12/18 14:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = -2768413316655692988L;

    private static final Logger LOGGER = LoggerFactory.getLogger(Result.class);

    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    private static Map<Integer, String> errorCodesMap = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 5926543871947636498L;

        {
            put(FAIL, "系统繁忙");
            put(SUCCESS, "请求成功");
        }
    };
    protected Object data;
    private Integer errcode = SUCCESS;
    private String errmsg = "ok";
    private String msgid;

    public Result(Integer errcode, String errmsg, String msgid, Object data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.msgid = msgid;
        this.data = data;
    }

    public static Result success() {
        return new Result(SUCCESS, "ok", null, null);
    }

    public static Result success(Object data) {
        return new Result(SUCCESS, "ok", null, data);
    }

    public static Result success(Integer errcode, Object data) {
        return new Result(SUCCESS, "ok", null, data);
    }

    public static Result success(Integer errcode, String errmsg, Object data) {
        return new Result(SUCCESS, errmsg, null, data);
    }

    public static Result success(Integer errcode, String errmsg, String errmsgChinese, Object data) {
        return new Result(SUCCESS, errmsg, null, data);
    }

    public static Result fail() {
        return new Result(FAIL, "系统繁忙，请稍后再试", null, null);
    }

    public static Result fail(String errmsg) {
        return new Result(FAIL, errmsg, null, null);
    }

    public static Result fail(Integer errcode, String errmsg) {
        return new Result(errcode, errmsg, null, null);
    }

    public static Result fail(String errmsg, Object data) {
        return new Result(FAIL, errmsg, null, data);
    }

    public static Result fail(Integer errcode, String errmsg, Object data) {
        return new Result(errcode, errmsg, null, data);
    }

    public static Result fail(Integer errcode, String errmsg, String errmsgChinese) {
        return new Result(FAIL, errmsg, null, null);
    }

    public static Result noPermission() {
        return new Result(-2, "无访问权限", "-2", null);
    }

    public static Result noPermission(String errmsg) {
        return new Result(-2, errmsg, "-2", null);
    }

    public static Map<Integer, String> getErrorCodesMap() {
        return errorCodesMap;
    }

    public static void setErrorCodesMap(Map<Integer, String> errorCodesMap) {
        Result.errorCodesMap = errorCodesMap;
    }

}
