package com.createw.hr.commons.enums;

public enum ResponseStatus {
    SUCCESS(200, "success"),            //成功
    FAIL(400,"推送失败"),
    NOT_EXISTS(404, "不存在"),
    NO_AUTHORITY(401, "没有权限"),
    SERVER_ERROR(500, "服务器错误"),
    SERVER_BUSY(503, "服务器被怪兽啃了，正在抢救"),
    UNKNOWN(999, "unknown"),//未知错误

    INVALID_SERVICE(199, "invalid service"),//服务不可用
    BUSIERROR(4000, "服务器维护中，请稍后"),
    SERVER_EXCEPTION(5000, "service exception"),

    PARAM_ERROR(1900,"参数错误"),
    PARAMETER_ILLEGAL(1901, "参数格式错误"),
    UPDATE_FAILED(1902, "更新失败"),
    DEL_FAILED(1903,"删除失败"),
    SAVE_FAILED(1904,"保存失败"),
    PAY_ERROR(1905,"生成预支付订单失败");


    int code;
    String message;
    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
