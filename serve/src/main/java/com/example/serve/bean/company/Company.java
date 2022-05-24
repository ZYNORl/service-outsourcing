package com.example.serve.bean.company;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 公司信息
 */
public class Company {
    private int id;
    private String name;
    private String introduce;
    private String address;
    private String password;
    private String tel;
    private String legalperson;
    private String fund;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;
    private String type;
    private String status;
    private String code;
    private String range;
    private String photo;
    private String personnum;

    public Company() {
    }

    public Company(int id, String name, String introduce, String address, String password, String tel, String legalperson, String fund, Date date, String type, String status, String code, String range, String photo, String personnum) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.address = address;
        this.password = password;
        this.tel = tel;
        this.legalperson = legalperson;
        this.fund = fund;
        this.date = date;
        this.type = type;
        this.status = status;
        this.code = code;
        this.range = range;
        this.photo = photo;
        this.personnum = personnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPersonnum() {
        return personnum;
    }

    public void setPersonnum(String personnum) {
        this.personnum = personnum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"introduce\":\"")
                .append(introduce).append('\"');
        sb.append(",\"address\":\"")
                .append(address).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"tel\":\"")
                .append(tel).append('\"');
        sb.append(",\"legalperson\":\"")
                .append(legalperson).append('\"');
        sb.append(",\"fund\":\"")
                .append(fund).append('\"');
        sb.append(",\"date\":\"")
                .append(date).append('\"');
        sb.append(",\"type\":\"")
                .append(type).append('\"');
        sb.append(",\"status\":\"")
                .append(status).append('\"');
        sb.append(",\"code\":\"")
                .append(code).append('\"');
        sb.append(",\"range\":\"")
                .append(range).append('\"');
        sb.append(",\"photo\":\"")
                .append(photo).append('\"');
        sb.append(",\"personnum\":\"")
                .append(personnum).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
