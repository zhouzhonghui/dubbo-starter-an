package com.boot.dubbo.domain;


public class BaseResponse extends BaseDomain{
    private static final long serialVersionUID = -4774033156511481606L;

    /**
     * 响应码
     */
    private String retCode;
    /**
     * 响应信息
     */
    private String errMsg;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
