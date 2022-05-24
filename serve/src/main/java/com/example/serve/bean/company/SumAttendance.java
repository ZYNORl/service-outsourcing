package com.example.serve.bean.company;

public class SumAttendance {
    private Integer userid;
    private Integer comid;
    private Integer leavesum;
    private Integer latesum;
    private Integer cardsum;
    private Integer overworksum;

    public SumAttendance() {
    }

    public SumAttendance(Integer userid, Integer comid, Integer leavesum, Integer latesum, Integer cardsum, Integer overworksum) {
        this.userid = userid;
        this.comid = comid;
        this.leavesum = leavesum;
        this.latesum = latesum;
        this.cardsum = cardsum;
        this.overworksum = overworksum;
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

    public Integer getLeavesum() {
        return leavesum;
    }

    public void setLeavesum(Integer leavesum) {
        this.leavesum = leavesum;
    }

    public Integer getLatesum() {
        return latesum;
    }

    public void setLatesum(Integer latesum) {
        this.latesum = latesum;
    }

    public Integer getCardsum() {
        return cardsum;
    }

    public void setCardsum(Integer cardsum) {
        this.cardsum = cardsum;
    }

    public Integer getOverworksum() {
        return overworksum;
    }

    public void setOverworksum(Integer overworksum) {
        this.overworksum = overworksum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userid\":")
                .append(userid);
        sb.append(",\"comid\":")
                .append(comid);
        sb.append(",\"leavesum\":")
                .append(leavesum);
        sb.append(",\"latesum\":")
                .append(latesum);
        sb.append(",\"cardsum\":")
                .append(cardsum);
        sb.append(",\"overworksum\":")
                .append(overworksum);
        sb.append('}');
        return sb.toString();
    }
}
