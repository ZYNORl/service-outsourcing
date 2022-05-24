package com.example.serve.service;

import com.example.serve.Dao.CompanyDao;
import com.example.serve.bean.company.*;
import com.example.serve.bean.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyDao companyDao;
    @Override
    public Integer loginByTelCode(String tel) {
        if(companyDao.loginByTelCode(tel)!=null){
            return companyDao.loginByTelCode(tel);
        }else{
            return  -1;
        }
    }

    @Override
    public Company getCompanyById(Integer comid) {
        return companyDao.getCompanyById(comid);
    }

    @Override
    public void setIntroduce(String introduce, Integer comid,String personnum) {
        companyDao.setIntroduce(introduce,comid,personnum);
    }

    @Override
    public Integer addSubmitJob(SubmitJob submitJob) {
        companyDao.addSubmitJob(submitJob);
        System.out.println(submitJob.getId());
        return submitJob.getId();
    }

    @Override
    public SubmitJob getSubmitJob(Integer JobId) {
        return companyDao.getSubmitJob(JobId);
    }

    @Override
    public void addToudi(Integer jobid, Integer userid,Date time,Double scores,String position,Integer comid) {
        companyDao.addToudi(jobid, userid,time,scores,position,comid);
    }

    @Override
    public List<Toudi> getToudiListByComId(Integer comid) {
        return companyDao.getToudiListByComId(comid);
    }

    @Override
    public List<User> getUsersByComId(Integer comid){
        return companyDao.getUsersByComId(comid);
    }

    @Override
    public Integer getUseridByUserInfo(User user) {
        return companyDao.getUseridByUserInfo(user)==null?-1:companyDao.getUseridByUserInfo(user);
    }

    @Override
    public Integer loginById(Company company) {
        return companyDao.loginById(company);
    }

    @Override
    public List<Attendance> getAttendanceByUserIdAndComId(Integer userid, Integer comid) {
        return companyDao.getAttendanceByUserIdAndComId(userid,comid);
    }

    @Override
    public List<Attendance> getAttendanceListByComId(Integer comid) {
        return companyDao.getAttendanceListByComId(comid);
    }

    @Override
    public List<Attendance> getAttendanceListByDate(String firstDate, String lastDate, Integer comid) {
        return companyDao.getAttendanceListByDate(firstDate, lastDate, comid);
    }

    @Override
    public void editAttendance(Attendance attendance) {
        companyDao.editAttendance(attendance);
    }

    @Override
    public void updatePerformance(Performance performance) {
        companyDao.updatePerformance(performance);
    }

    @Override
    public void updateComment(Comment comment) {
        companyDao.updateComment(comment);
    }

    @Override
    public void updateEvent(Event event) {
        companyDao.updateEvent(event);
    }

    @Override
    public String getPerformance(Integer userid, Integer comid) {
        return companyDao.getPerformance(userid,comid);
    }

    @Override
    public String getComment(Integer userid, Integer comid) {
        return companyDao.getComment(userid, comid);
    }

    @Override
    public String getEvent(Integer userid, Integer comid) {
        return companyDao.getEvent(userid, comid);
    }
}
