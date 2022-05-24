package com.example.serve.bean.position;

import java.util.Arrays;
import java.util.List;

public class PosSkill {
    private List<Skill> skillList;
    private List<IndicatorSkill> indicatorSkillList;
    private int[] scoreList;

    public PosSkill() {
    }

    public PosSkill(List<Skill> skillList, List<IndicatorSkill> indicatorSkillList, int[] scoreList) {
        this.skillList = skillList;
        this.indicatorSkillList = indicatorSkillList;
        this.scoreList = scoreList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<IndicatorSkill> getIndicatorSkillList() {
        return indicatorSkillList;
    }

    public void setIndicatorSkillList(List<IndicatorSkill> indicatorSkillList) {
        this.indicatorSkillList = indicatorSkillList;
    }

    public int[] getScoreList() {
        return scoreList;
    }

    public void setScoreList(int[] scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"skillList\":")
                .append(skillList);
        sb.append(",\"indicatorSkillList\":")
                .append(indicatorSkillList);
        sb.append(",\"scoreList\":")
                .append(Arrays.toString(scoreList));
        sb.append('}');
        return sb.toString();
    }
}
