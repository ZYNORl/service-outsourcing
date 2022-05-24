package com.example.serve.bean.company;

public class Event {
    private Integer userid;
    public Integer comid;
    private String text;

    public Event() {
    }

    public Event(Integer userid, Integer comid, String text) {
        this.userid = userid;
        this.comid = comid;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append(",\"userid\":")
                .append(userid);
        sb.append(",\"comid\":")
                .append(comid);
        sb.append(",\"text\":\"")
                .append(text).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
