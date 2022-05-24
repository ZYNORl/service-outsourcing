package com.example.serve.bean.company;

public class CompanyRecord {
    private Integer comid;
    private String comName;
    private Integer userid;
    private SumAttendance sumAttendance;
    private Performance performance;
    private Event event;
    private Comment comment;

    public CompanyRecord() {
    }

    public CompanyRecord(Integer comid, String comName, Integer userid, SumAttendance sumAttendance, Performance performance, Event event, Comment comment) {
        this.comid = comid;
        this.comName = comName;
        this.userid = userid;
        this.sumAttendance = sumAttendance;
        this.performance = performance;
        this.event = event;
        this.comment = comment;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
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

    public SumAttendance getSumAttendance() {
        return sumAttendance;
    }

    public void setSumAttendance(SumAttendance sumAttendance) {
        this.sumAttendance = sumAttendance;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"comid\":")
                .append(comid);
        sb.append(",\"comName\":\"")
                .append(comName).append('\"');
        sb.append(",\"userid\":")
                .append(userid);
        sb.append(",\"sumAttendance\":")
                .append(sumAttendance);
        sb.append(",\"performance\":")
                .append(performance);
        sb.append(",\"event\":")
                .append(event);
        sb.append(",\"comment\":")
                .append(comment);
        sb.append('}');
        return sb.toString();
    }
}
