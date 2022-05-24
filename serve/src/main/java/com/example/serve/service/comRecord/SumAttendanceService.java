package com.example.serve.service.comRecord;

import com.example.serve.bean.company.SumAttendance;

import java.util.List;

public interface SumAttendanceService {
    SumAttendance getSumAttendanceByUserIdAndComId(Integer userid, Integer comid);
    List<SumAttendance> getSumAttendanceByUserIdNoComId(Integer userid, Integer comid);
    List<SumAttendance> getSumAttendanceByUserId(Integer userid);
}
