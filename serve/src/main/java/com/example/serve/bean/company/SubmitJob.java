package com.example.serve.bean.company;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SubmitJob {
    private Integer id;
    private Integer comid;
    private String position;
    private String extraAsk;
    private String edu;
    private String yearLimit;
    private String address;
    private String welfare;
    private  String salary;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date submitdate;


    public SubmitJob() {
    }

    public SubmitJob(Integer id, Integer comid, String position, String extraAsk, String edu, String yearLimit, String address, String welfare, String salary, Date submitdate) {
        this.id = id;
        this.comid = comid;
        this.position = position;
        this.extraAsk = extraAsk;
        this.edu = edu;
        this.yearLimit = yearLimit;
        this.address = address;
        this.welfare = welfare;
        this.salary = salary;
        this.submitdate = submitdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExtraAsk() {
        return extraAsk;
    }

    public void setExtraAsk(String extraAsk) {
        this.extraAsk = extraAsk;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getYearLimit() {
        return yearLimit;
    }

    public void setYearLimit(String yearLimit) {
        this.yearLimit = yearLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"comid\":")
                .append(comid);
        sb.append(",\"position\":\"")
                .append(position).append('\"');
        sb.append(",\"extraAsk\":\"")
                .append(extraAsk).append('\"');
        sb.append(",\"edu\":\"")
                .append(edu).append('\"');
        sb.append(",\"yearLimit\":\"")
                .append(yearLimit).append('\"');
        sb.append(",\"address\":\"")
                .append(address).append('\"');
        sb.append(",\"welfare\":\"")
                .append(welfare).append('\"');
        sb.append(",\"salary\":\"")
                .append(salary).append('\"');
        sb.append(",\"submitdate\":\"")
                .append(submitdate).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
