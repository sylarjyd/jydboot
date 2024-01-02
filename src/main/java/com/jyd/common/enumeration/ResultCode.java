package com.jyd.common.enumeration;

/**
 * 〈响应状态码〉
 *
 */
public enum ResultCode {

    //处理成功
    SUCCESS(200, "处理成功"),

    //处理失败
    FAILED(500, "处理失败"),

    //未登录
    NOT_LOGIN(401, "用户没有登陆或登录失效"),

    //未激活
    NOT_ACTIVED(402, "未激活"),

    //访问拒绝
    ACCESS_DENIED(403, "该用户没有权限访问"),

    //数据库错误
    DB_ERROR(503, "数据库错误"),

    //参数错误
    PARAM_PARAMETER_ERROR(501, "参数错误"),

    //参数为空
    PARAM_PARAMETER_IS_NULL(502, "参数为空"),

    // 未知异常
    UNKNOWN_ERROR(504, "服务内部错误, 请联系管理员"),

    // npe异常
    NPE_ERROR(505, "服务内部错误: NPE, 请联系管理员"),

    // sql异常
    SQL_ERROR(506, "服务内部错误: SQL, 请联系管理员"),

    CAPTCHA_CREATE_ERROR(507, "生成验证码错误, 请稍后重试"),

    CAPTCHA_EXPIRE_ERROR(508, "验证码失效"),

    IP_NOT_ACCESS(509, "请求IP不合法，请联系管理员添加白名单"),
    ;

    private int code;

    private String message;

    ResultCode(int code, String message) {
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

    public String getMessage(String message) {
        return String.format(this.message, message == null ? "" : message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
