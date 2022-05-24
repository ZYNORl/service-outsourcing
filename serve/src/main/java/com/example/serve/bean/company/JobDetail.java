package com.example.serve.bean.company;

public class JobDetail {
    private Job job;
    private JobScoreList jobScoreList;

    public JobDetail() {
    }

    public JobDetail(Job job, JobScoreList jobScoreList) {
        this.job = job;
        this.jobScoreList = jobScoreList;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobScoreList getJobScoreList() {
        return jobScoreList;
    }

    public void setJobScoreList(JobScoreList jobScoreList) {
        this.jobScoreList = jobScoreList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append(",\"job\":")
                .append(job);
        sb.append(",\"jobScoreList\":")
                .append(jobScoreList);
        sb.append('}');
        return sb.toString();
    }
}
