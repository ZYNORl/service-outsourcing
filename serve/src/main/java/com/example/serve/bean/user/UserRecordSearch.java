package com.example.serve.bean.user;

public class UserRecordSearch {
    private Integer userid;
    private String photo;
    private String name;
    private String maxEdu;
    private String posName;
    private double level;

    public UserRecordSearch() {
    }

    public UserRecordSearch(Integer userid, String photo, String name, String maxEdu, String posName, double level) {
        this.userid = userid;
        this.photo = photo;
        this.name = name;
        this.maxEdu = maxEdu;
        this.posName = posName;
        this.level = level;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaxEdu() {
        return maxEdu;
    }

    public void setMaxEdu(String maxEdu) {
        this.maxEdu = maxEdu;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
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
        sb.append("\"userid\":")
                .append(userid);
        sb.append(",\"photo\":\"")
                .append(photo).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"maxEdu\":\"")
                .append(maxEdu).append('\"');
        sb.append(",\"posName\":\"")
                .append(posName).append('\"');
        sb.append(",\"level\":")
                .append(level);
        sb.append('}');
        return sb.toString();
    }
}
