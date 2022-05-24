package com.example.serve.bean.company;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Attendance {
    private Integer id;
    private Integer userid;
    private Integer comid;
    private Integer leavenum;
    private Integer latenum;
    private Integer cardnum;
    private Integer overworknum;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date dotime;

    public Attendance() {
    }

    public Attendance(Integer id, Integer userid, Integer comid, Integer leavenum, Integer latenum, Integer cardnum, Integer overworknum, Date dotime) {
        this.id = id;
        this.userid = userid;
        this.comid = comid;
        this.leavenum = leavenum;
        this.latenum = latenum;
        this.cardnum = cardnum;
        this.overworknum = overworknum;
        this.dotime = dotime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"userid\":")
                .append(userid);
        sb.append(",\"comid\":")
                .append(comid);
        sb.append(",\"leavenum\":")
                .append(leavenum);
        sb.append(",\"latenum\":")
                .append(latenum);
        sb.append(",\"cardnum\":")
                .append(cardnum);
        sb.append(",\"overworknum\":")
                .append(overworknum);
        sb.append(",\"dotime\":\"")
                .append(dotime).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
