package com.example.serve.bean.user;
import com.example.serve.bean.extrkill;
import com.example.serve.bean.honor;
import com.example.serve.bean.practice;
import com.example.serve.bean.project;
import com.example.serve.bean.user.User;

import java.util.List;

public class userInfo {
    private User user;
    //技能
    private List<extrkill> domainSkills;
    //荣誉
    private List<honor> domains;
    private List<practice> domainPractices;
    private List<project> domainProjects;

    public userInfo() {
    }

    public userInfo(User user, List<extrkill> domainSkills, List<honor> domains, List<practice> domainPractices, List<project> domainProjects) {
        this.user = user;
        this.domainSkills = domainSkills;
        this.domains = domains;
        this.domainPractices = domainPractices;
        this.domainProjects = domainProjects;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<extrkill> getDomainSkills() {
        return domainSkills;
    }

    public void setDomainSkills(List<extrkill> domainSkills) {
        this.domainSkills = domainSkills;
    }

    public List<honor> getDomains() {
        return domains;
    }

    public void setDomains(List<honor> domains) {
        this.domains = domains;
    }

    public List<practice> getDomainPractices() {
        return domainPractices;
    }

    public void setDomainPractices(List<practice> domainPractices) {
        this.domainPractices = domainPractices;
    }

    public List<project> getDomainProjects() {
        return domainProjects;
    }

    public void setDomainProjects(List<project> domainProjects) {
        this.domainProjects = domainProjects;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"user\":")
                .append(user);
        sb.append(",\"domainSkills\":")
                .append(domainSkills);
        sb.append(",\"domains\":")
                .append(domains);
        sb.append(",\"domainPractices\":")
                .append(domainPractices);
        sb.append(",\"domainProjects\":")
                .append(domainProjects);
        sb.append('}');
        return sb.toString();
    }
}
