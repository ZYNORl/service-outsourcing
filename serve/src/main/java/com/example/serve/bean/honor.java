package com.example.serve.bean;

public class honor {
    Integer id;
    Integer userid;
    String text;
    String url;
    public honor(){

    }
    public honor(Integer id, Integer userid, String text, String url) {
        this.id = id;
        this.userid = userid;
        this.text = text;
        this.url = url;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"userid\":")
                .append(userid);
        sb.append(",\"text\":\"")
                .append(text).append('\"');
        sb.append(",\"url\":\"")
                .append(url).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
