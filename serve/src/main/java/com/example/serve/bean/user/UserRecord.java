package com.example.serve.bean.user;

import com.example.serve.bean.company.CompanyRecord;

import java.util.List;

public class UserRecord {
    private Integer id;
    private Integer age;
    private String companyName;
    private userInfo userInfo;
    private String sex;
    //除了自己的
    private List<CompanyRecord> companyRecordList;
    //自己的
    private CompanyRecord companyRecord;
    //状态码
    private Integer Code;
    public UserRecord() {
    }

    public UserRecord(Integer id, Integer age, String companyName, com.example.serve.bean.user.userInfo userInfo, String sex, List<CompanyRecord> companyRecordList, CompanyRecord companyRecord, Integer code) {
        this.id = id;
        this.age = age;
        this.companyName = companyName;
        this.userInfo = userInfo;
        this.sex = sex;
        this.companyRecordList = companyRecordList;
        this.companyRecord = companyRecord;
        Code = code;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.example.serve.bean.user.userInfo getUserInfo() {
        return userInfo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUserInfo(com.example.serve.bean.user.userInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<CompanyRecord> getCompanyRecordList() {
        return companyRecordList;
    }

    public void setCompanyRecordList(List<CompanyRecord> companyRecordList) {
        this.companyRecordList = companyRecordList;
    }

    public CompanyRecord getCompanyRecord() {
        return companyRecord;
    }

    public void setCompanyRecord(CompanyRecord companyRecord) {
        this.companyRecord = companyRecord;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"age\":")
                .append(age);
        sb.append(",\"companyName\":\"")
                .append(companyName).append('\"');
        sb.append(",\"userInfo\":")
                .append(userInfo);
        sb.append(",\"sex\":\"")
                .append(sex).append('\"');
        sb.append(",\"companyRecordList\":")
                .append(companyRecordList);
        sb.append(",\"companyRecord\":")
                .append(companyRecord);
        sb.append(",\"Code\":")
                .append(Code);
        sb.append('}');
        return sb.toString();
    }
}
