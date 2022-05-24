package com.example.serve.bean.company;

import java.util.ArrayList;

public class Job {
    private double scores;
    private SubmitJob submitJob;
    private Company company;
    private ArrayList<Integer> matchScores;

    public Job() {
    }

    public Job(double scores, SubmitJob submitJob, Company company, ArrayList<Integer> matchScores) {
        this.scores = scores;
        this.submitJob = submitJob;
        this.company = company;
        this.matchScores = matchScores;
    }

    public double getScores() {
        return scores;
    }

    public void setScores(double scores) {
        this.scores = scores;
    }

    public ArrayList<Integer> getMatchScores() {
        return matchScores;
    }

    public void setMatchScores(ArrayList<Integer> matchScores) {
        this.matchScores = matchScores;
    }

    public SubmitJob getSubmitJob() {
        return submitJob;
    }

    public void setSubmitJob(SubmitJob submitJob) {
        this.submitJob = submitJob;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"scores\":")
                .append(scores);
        sb.append(",\"submitJob\":")
                .append(submitJob);
        sb.append(",\"company\":")
                .append(company);
        sb.append(",\"matchScores\":")
                .append(matchScores);
        sb.append('}');
        return sb.toString();
    }
}
