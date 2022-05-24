package com.example.serve.bean.company;

import java.util.ArrayList;

public class JobScoreList {
    private Integer id;
    private ArrayList<Integer> scorelist;

    public JobScoreList() {
    }

    public JobScoreList(Integer id, ArrayList<Integer> scorelist) {
        this.id = id;
        this.scorelist = scorelist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"scorelist\":")
                .append(scorelist);
        sb.append('}');
        return sb.toString();
    }

    public ArrayList<Integer> getScorelist() {
        return scorelist;
    }

    public void setScorelist(ArrayList<Integer> scorelist) {
        this.scorelist = scorelist;
    }
}
