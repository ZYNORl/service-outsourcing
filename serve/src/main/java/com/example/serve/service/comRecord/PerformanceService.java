package com.example.serve.service.comRecord;

import com.example.serve.bean.company.Performance;

import java.util.List;

public interface PerformanceService {
    Performance getPerformanceByUserIdAndComId(Integer userid, Integer comid);
    List<Performance> getPerformanceByUserIdNoComId(Integer userid,Integer comid);
    List<Performance> getPerformanceByUserId(Integer userid);
}
