package com.example.serve.bean.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 用户信息
 */
public class User {
    private Integer id;
    private String name;
    private String ident;
    private String identNumber;
    private String photo;
    private String tel;
    private String maxEduBack;
    private String eduBen;
    private String eduSuo;
    private String eduBo;
    /**
     * 出生日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birth;
    private String email;
    private String password;
    private String benMajor;
    private String SuoMajor;
    private String BoMajor;
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private Date eduBenDateStart;
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private Date eduBenDateEnd;
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private Date eduSuoDateStart;
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private Date eduSuoDateEnd;
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private Date eduBoDateStart;
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    private Date eduBoDateEnd;
    private String posname;
    private Integer comid;
    private Integer status;
    private Integer sex;
    private String politicStatus;
    private String nation;
    private Integer english;
    private String englishUrl;
    private String introduce;
    private String evaluation;
    private String hobby;

    public User() {
    }

    public User(Integer id, String name, String ident, String identNumber, String photo, String tel, String maxEduBack, String eduBen, String eduSuo, String eduBo, Date birth, String email, String password, String benMajor, String suoMajor, String boMajor, Date eduBenDateStart, Date eduBenDateEnd, Date eduSuoDateStart, Date eduSuoDateEnd, Date eduBoDateStart, Date eduBoDateEnd, String posname, Integer comid, Integer status, Integer sex, String politicStatus, String nation, Integer english, String englishUrl, String introduce, String evaluation, String hobby) {
        this.id = id;
        this.name = name;
        this.ident = ident;
        this.identNumber = identNumber;
        this.photo = photo;
        this.tel = tel;
        this.maxEduBack = maxEduBack;
        this.eduBen = eduBen;
        this.eduSuo = eduSuo;
        this.eduBo = eduBo;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.benMajor = benMajor;
        SuoMajor = suoMajor;
        BoMajor = boMajor;
        this.eduBenDateStart = eduBenDateStart;
        this.eduBenDateEnd = eduBenDateEnd;
        this.eduSuoDateStart = eduSuoDateStart;
        this.eduSuoDateEnd = eduSuoDateEnd;
        this.eduBoDateStart = eduBoDateStart;
        this.eduBoDateEnd = eduBoDateEnd;
        this.posname = posname;
        this.comid = comid;
        this.status = status;
        this.sex = sex;
        this.politicStatus = politicStatus;
        this.nation = nation;
        this.english = english;
        this.englishUrl = englishUrl;
        this.introduce = introduce;
        this.evaluation = evaluation;
        this.hobby = hobby;
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

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMaxEduBack() {
        return maxEduBack;
    }

    public void setMaxEduBack(String maxEduBack) {
        this.maxEduBack = maxEduBack;
    }

    public String getEduBen() {
        return eduBen;
    }

    public void setEduBen(String eduBen) {
        this.eduBen = eduBen;
    }

    public String getEduSuo() {
        return eduSuo;
    }

    public void setEduSuo(String eduSuo) {
        this.eduSuo = eduSuo;
    }

    public String getEduBo() {
        return eduBo;
    }

    public void setEduBo(String eduBo) {
        this.eduBo = eduBo;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBenMajor() {
        return benMajor;
    }

    public void setBenMajor(String benMajor) {
        this.benMajor = benMajor;
    }

    public String getSuoMajor() {
        return SuoMajor;
    }

    public void setSuoMajor(String suoMajor) {
        SuoMajor = suoMajor;
    }

    public String getBoMajor() {
        return BoMajor;
    }

    public void setBoMajor(String boMajor) {
        BoMajor = boMajor;
    }

    public Date getEduBenDateStart() {
        return eduBenDateStart;
    }

    public void setEduBenDateStart(Date eduBenDateStart) {
        this.eduBenDateStart = eduBenDateStart;
    }

    public Date getEduBenDateEnd() {
        return eduBenDateEnd;
    }

    public void setEduBenDateEnd(Date eduBenDateEnd) {
        this.eduBenDateEnd = eduBenDateEnd;
    }

    public Date getEduSuoDateStart() {
        return eduSuoDateStart;
    }

    public void setEduSuoDateStart(Date eduSuoDateStart) {
        this.eduSuoDateStart = eduSuoDateStart;
    }

    public Date getEduSuoDateEnd() {
        return eduSuoDateEnd;
    }

    public void setEduSuoDateEnd(Date eduSuoDateEnd) {
        this.eduSuoDateEnd = eduSuoDateEnd;
    }

    public Date getEduBoDateStart() {
        return eduBoDateStart;
    }

    public void setEduBoDateStart(Date eduBoDateStart) {
        this.eduBoDateStart = eduBoDateStart;
    }

    public Date getEduBoDateEnd() {
        return eduBoDateEnd;
    }

    public void setEduBoDateEnd(Date eduBoDateEnd) {
        this.eduBoDateEnd = eduBoDateEnd;
    }

    public String getPosname() {
        return posname;
    }

    public void setPosname(String posname) {
        this.posname = posname;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPoliticStatus() {
        return politicStatus;
    }

    public void setPoliticStatus(String politicStatus) {
        this.politicStatus = politicStatus;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public String getEnglishUrl() {
        return englishUrl;
    }

    public void setEnglishUrl(String englishUrl) {
        this.englishUrl = englishUrl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"ident\":\"")
                .append(ident).append('\"');
        sb.append(",\"identNumber\":\"")
                .append(identNumber).append('\"');
        sb.append(",\"photo\":\"")
                .append(photo).append('\"');
        sb.append(",\"tel\":\"")
                .append(tel).append('\"');
        sb.append(",\"maxEduBack\":\"")
                .append(maxEduBack).append('\"');
        sb.append(",\"eduBen\":\"")
                .append(eduBen).append('\"');
        sb.append(",\"eduSuo\":\"")
                .append(eduSuo).append('\"');
        sb.append(",\"eduBo\":\"")
                .append(eduBo).append('\"');
        sb.append(",\"birth\":\"")
                .append(birth).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"benMajor\":\"")
                .append(benMajor).append('\"');
        sb.append(",\"SuoMajor\":\"")
                .append(SuoMajor).append('\"');
        sb.append(",\"BoMajor\":\"")
                .append(BoMajor).append('\"');
        sb.append(",\"eduBenDateStart\":\"")
                .append(eduBenDateStart).append('\"');
        sb.append(",\"eduBenDateEnd\":\"")
                .append(eduBenDateEnd).append('\"');
        sb.append(",\"eduSuoDateStart\":\"")
                .append(eduSuoDateStart).append('\"');
        sb.append(",\"eduSuoDateEnd\":\"")
                .append(eduSuoDateEnd).append('\"');
        sb.append(",\"eduBoDateStart\":\"")
                .append(eduBoDateStart).append('\"');
        sb.append(",\"eduBoDateEnd\":\"")
                .append(eduBoDateEnd).append('\"');
        sb.append(",\"posname\":\"")
                .append(posname).append('\"');
        sb.append(",\"comid\":")
                .append(comid);
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"sex\":")
                .append(sex);
        sb.append(",\"politicStatus\":\"")
                .append(politicStatus).append('\"');
        sb.append(",\"nation\":\"")
                .append(nation).append('\"');
        sb.append(",\"english\":")
                .append(english);
        sb.append(",\"englishUrl\":\"")
                .append(englishUrl).append('\"');
        sb.append(",\"introduce\":\"")
                .append(introduce).append('\"');
        sb.append(",\"evaluation\":\"")
                .append(evaluation).append('\"');
        sb.append(",\"hobby\":\"")
                .append(hobby).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
