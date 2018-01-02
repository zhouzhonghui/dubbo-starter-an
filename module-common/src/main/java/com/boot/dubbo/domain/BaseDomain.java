package com.boot.dubbo.domain;


import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.beans.Transient;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseDomain implements Serializable{
    private static final long serialVersionUID = -3683907261691110389L;

    /**
     * 客户端id   即手机号码
     */

    private String clientId ;

    /**
     * 客户端渠道  pc或app
     */
    private String clientChnl ;

    /**
     * 交易时间
     */
    private String tranDate ;

    /**
     * 流水号
     */
    private String terminalNo;

    /**
     * 服务名称
     */
    private String serverName;

    /**
     * 版本号
     */
    private String version;

    /**
     * 资源名称
     */
    private String resource ;

    @Transient
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Transient
    public String getClientChnl() {
        return clientChnl;
    }

    public void setClientChnl(String clientChnl) {
        this.clientChnl = clientChnl;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    @Transient
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Transient
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Transient
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("clientId", clientId)
                .add("clientChnl", clientChnl)
                .add("tranDate", tranDate)
                .add("terminalNo", terminalNo)
                .add("serverName", serverName)
                .add("version", version)
                .add("resource", resource)
                .toString();
    }
}
