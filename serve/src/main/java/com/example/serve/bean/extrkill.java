package com.example.serve.bean;

public class extrkill {
    Integer id;
    String text;
    Integer userid;
    public extrkill(){

    }
    public extrkill(Integer id, String text, Integer userid) {
        this.id = id;
        this.text = text;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"text\":\"")
                .append(text).append('\"');
        sb.append(",\"userid\":")
                .append(userid);
        sb.append('}');
        return sb.toString();
    }
}
