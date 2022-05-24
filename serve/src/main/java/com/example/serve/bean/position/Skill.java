package com.example.serve.bean.position;

public class Skill {
    private String skill;
    private Integer score;

    public Skill() {
    }

    public Skill(String skill, Integer score) {
        this.skill = skill;
        this.score = score;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"skill\":\"")
                .append(skill).append('\"');
        sb.append(",\"score\":")
                .append(score);
        sb.append('}');
        return sb.toString();
    }
}


