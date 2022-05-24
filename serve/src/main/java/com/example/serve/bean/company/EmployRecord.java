package com.example.serve.bean.company;

public class EmployRecord {
    private Integer id;
    private Integer userid;
    private Integer comid;

    public EmployRecord() {
    }

    public EmployRecord(Integer id, Integer userid, Integer comid) {
        this.id = id;
        this.userid = userid;
        this.comid = comid;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"userid\":")
                .append(userid);
        sb.append(",\"comid\":")
                .append(comid);
        sb.append('}');
        return sb.toString();
    }
}
