package com.wzw.wangziwei.ddd.api.utils;

import java.util.HashMap;

public class UmsResult extends HashMap<String,Object> {
    public static UmsResult buildSuccess(Object data) {
        UmsResult umsResult = new UmsResult();
        umsResult.put("code", 200);
        umsResult.put("msg", "成功");
        umsResult.put("data", data);
        return umsResult;
    }

    public static UmsResult buildSuccess() {
        UmsResult umsResult = new UmsResult();
        umsResult.put("code", 200);
        umsResult.put("msg", "成功");
        return umsResult;
    }

    public static UmsResult buildFailed(Integer code, String msg) {
        UmsResult umsResult = new UmsResult();
        umsResult.put("code", code);
        umsResult.put("msg", msg);
        return umsResult;
    }
}
