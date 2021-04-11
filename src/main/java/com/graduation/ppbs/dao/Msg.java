package com.graduation.ppbs.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Msg {
    private Integer msgid;
    private Integer auditid;
    private Integer msgtype;
    private String msg;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    @Override
    public String toString() {
        return "Msg{" +
                "msgid=" + msgid +
                ", auditid=" + auditid +
                ", msgtype=" + msgtype +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public Integer getAuditid() {
        return auditid;
    }

    public void setAuditid(Integer auditid) {
        this.auditid = auditid;
    }

    public Integer getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(Integer msgtype) {
        this.msgtype = msgtype;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
