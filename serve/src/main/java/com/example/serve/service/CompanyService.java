package com.example.serve.service;

import com.example.serve.bean.company.*;
import com.example.serve.bean.user.User;
import org.springframework.data.relational.core.sql.In;

import java.util.Date;
import java.util.List;

public interface CompanyService {
    Integer loginByTelCode(String tel);
    Company getCompanyById(Integer comid);
    void setIntroduce(String introduce,Integer comid,String personnum);
    Integer addSubmitJob(SubmitJob submitJob);
    SubmitJob getSubmitJob(Integer JobId);
    void addToudi(Integer jobid,Integer userid,Date time,Double scores,String position,Integer comid);
    List<Toudi> getToudiListByComId(Integer comid);
    List<User> getUsersByComId(Integer comid);
    Integer getUseridByUserInfo(User user);
    Integer loginById(Company company);
    //根据comid和userid查询考勤数据
    List<Attendance> getAttendanceByUserIdAndComId(Integer userid,Integer comid);
    //根据comid查询员工考勤列表
    List<Attendance> getAttendanceListByComId(Integer comid);
    //根据时间段查询员工考勤列表
    List<Attendance> getAttendanceListByDate(String firstDate,String lastDate,Integer comid);
    void editAttendance(Attendance attendance);
    //企业对员工档案的编辑
    void updatePerformance(Performance performance);
    void updateComment(Comment comment);
    void updateEvent(Event event);
    String getPerformance(Integer userid, Integer comid);
    String getComment(Integer userid,Integer comid);
    String getEvent(Integer userid,Integer comid);
}
