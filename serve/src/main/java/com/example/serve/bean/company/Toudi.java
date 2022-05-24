package com.example.serve.bean.company;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Toudi {
    private Integer id;
    private Integer jobid;
    private Integer userid;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date time;
    private Double scores;
    private String position;
    private Integer comid;

    public Toudi() {
    }

    public Toudi(Integer id, Integer jobid, Integer userid, Date time, Double scores, String position, Integer comid) {
        this.id = id;
        this.jobid = jobid;
        this.userid = userid;
        this.time = time;
        this.scores = scores;
        this.position = position;
        this.comid = comid;
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

    public Double getScores() {
        return scores;
    }

    public void setScores(Double scores) {
        this.scores = scores;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
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
        sb.append(",\"scores\":")
                .append(scores);
        sb.append(",\"position\":\"")
                .append(position).append('\"');
        sb.append(",\"comid\":")
                .append(comid);
        sb.append('}');
        return sb.toString();
    }
}
