package com.example.serve.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class toudi {
    private Integer id;
    private Integer jobid;
    private Integer userid;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date time;

    public toudi() {
    }

    public toudi(Integer id, Integer jobid, Integer userid, Date time) {
        this.id = id;
        this.jobid = jobid;
        this.userid = userid;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"jobid\":")
                .append(jobid);
        sb.append(",\"userid\":")
                .append(userid);
        sb.append(",\"time\":\"")
                .append(time).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
