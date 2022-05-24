package com.example.serve.bean.company;

public class Comment {
    public Integer comid;
    private Integer userid;
    private String text;

    public Comment() {
    }

    public Comment( Integer comid, Integer userid, String text) {
        this.comid = comid;
        this.userid = userid;
        this.text = text;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append(",\"comid\":")
                .append(comid);
        sb.append(",\"userid\":")
                .append(userid);
        sb.append(",\"text\":\"")
                .append(text).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
