package com.example.serve.bean.company;

public class CompanyLogin {
    Integer comId;
    Integer status;

    public CompanyLogin() {
    }

    public CompanyLogin(Integer comId, Integer status) {
        this.comId = comId;
        this.status = status;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
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
        sb.append("\"comId\":")
                .append(comId);
        sb.append(",\"status\":")
                .append(status);
        sb.append('}');
        return sb.toString();
    }
}
