package com.example.serve.bean.company;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AttendanceBody {
    private Integer userid;
    private String posName;
    private String name;
    private Integer leavenum;
    private Integer latenum;
    private Integer cardnum;
    private Integer overworknum;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date dotime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeavenum() {
        return leavenum;
    }

    public void setLeavenum(Integer leavenum) {
        this.leavenum = leavenum;
    }

    public Integer getLatenum() {
        return latenum;
    }

    public void setLatenum(Integer latenum) {
        this.latenum = latenum;
    }

    public Integer getCardnum() {
        return cardnum;
    }

    public void setCardnum(Integer cardnum) {
        this.cardnum = cardnum;
    }

    public Integer getOverworknum() {
        return overworknum;
    }

    public void setOverworknum(Integer overworknum) {
        this.overworknum = overworknum;
    }

    public Date getDotime() {
        return dotime;
    }

    public void setDotime(Date dotime) {
        this.dotime = dotime;
    }

    public AttendanceBody() {
    }

    public AttendanceBody(Integer userid, String posName, String name, Integer leavenum, Integer latenum, Integer cardnum, Integer overworknum, Date dotime) {
        this.userid = userid;
        this.posName = posName;
        this.name = name;
        this.leavenum = leavenum;
        this.latenum = latenum;
        this.cardnum = cardnum;
        this.overworknum = overworknum;
        this.dotime = dotime;
    }
}
