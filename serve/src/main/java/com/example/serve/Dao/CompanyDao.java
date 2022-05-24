package com.example.serve.Dao;

import com.example.serve.bean.company.*;
import com.example.serve.bean.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.bytedeco.javacpp.presets.opencv_core;

import java.util.Date;
import java.util.List;

@Mapper
public interface CompanyDao {
    Integer loginByTelCode(String tel);
    Company getCompanyById(Integer comid);
    void setIntroduce(String introduce,Integer comid,String personnum);
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void addSubmitJob(SubmitJob submitJob);
    SubmitJob getSubmitJob(Integer JobId);
    List<User> getUsersByComId(Integer comid);
    Integer getUseridByUserInfo(User user);
    void addToudi(Integer jobid, Integer userid, Date time,Double scores,String position,Integer comid);
    List<Toudi> getToudiListByComId(Integer comid);
    Integer loginById(Company company);
    List<Attendance> getAttendanceByUserIdAndComId(Integer userid,Integer comid);
    List<Attendance> getAttendanceListByComId(Integer comid);
    List<Attendance> getAttendanceListByDate(String firstDate,String lastDate,Integer comid);
    void editAttendance(Attendance attendance);
    List<EmployRecord> getEmployRecordAll(Integer userid);
    List<EmployRecord> getEmployRecordNoComId(Integer userid,Integer comid);
    //查询不包含comid记录地userid的评价
    List<Comment> getCommentByUserId(Integer userid);
    List<Comment> getCommentByUserIdNoComId(Integer userid, Integer comid);
    //查询既包含comid又是userid的评价
    Comment getCommentByUserIdAndComId(Integer userid,Integer comid);
    Event getEventByUserIdAndComId(Integer userid,Integer comid);
    List<Event> getEventByUserId(Integer userid);
    List<Event> getEventByUserIdNoComId(Integer userid,Integer comid);
    Performance getPerformanceByUserIdAndComId(Integer userid, Integer comid);
    List<Performance> getPerformanceByUserId(Integer userid);
    List<Performance> getPerformanceByUserIdNoComId(Integer userid,Integer comid);
    List<Attendance> getSumAttendanceByUserId(Integer userid);
    List<Attendance> getSumAttendanceByUserIdNoComId(Integer userid,Integer comid);
    Attendance getSumAttendanceByUserIdAndComId(Integer userid,Integer comid);
    //企业对员工档案的编辑
    void updatePerformance(Performance performance);
    void updateComment(Comment comment);
    void updateEvent(Event event);
    String getPerformance(Integer userid, Integer comid);
    String getComment(Integer userid,Integer comid);
    String getEvent(Integer userid,Integer comid);
}
