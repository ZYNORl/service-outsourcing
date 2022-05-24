package com.example.serve.bean.company;

import java.util.Date;

public class Employee {
    private Integer id;
    private String name;
    private String posname;
    private Integer age;
    private String maxedu;
    private String email;
    private String tel;
    private Integer status;

    public Employee() {
    }

    public Employee(Integer id, String name, String posname, Integer age, String maxedu, String email, String tel, Integer status) {
        this.id = id;
        this.name = name;
        this.posname = posname;
        this.age = age;
        this.maxedu = maxedu;
        this.email = email;
        this.tel = tel;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosname() {
        return posname;
    }

    public void setPosname(String posname) {
        this.posname = posname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMaxedu() {
        return maxedu;
    }

    public void setMaxedu(String maxedu) {
        this.maxedu = maxedu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"posname\":\"")
                .append(posname).append('\"');
        sb.append(",\"age\":")
                .append(age);
        sb.append(",\"maxedu\":\"")
                .append(maxedu).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"tel\":\"")
                .append(tel).append('\"');
        sb.append(",\"status\":")
                .append(status);
        sb.append('}');
        return sb.toString();
    }
}
