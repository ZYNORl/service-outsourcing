package com.example.serve.service.comRecord;

import com.example.serve.Dao.CompanyDao;
import com.example.serve.bean.company.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService{
    @Autowired
    private CompanyDao companyDao;
    @Override
    public Performance getPerformanceByUserIdAndComId(Integer userid, Integer comid) {
        return companyDao.getPerformanceByUserIdAndComId(userid, comid);
    }

    @Override
    public List<Performance> getPerformanceByUserIdNoComId(Integer userid, Integer comid) {
        List<Performance> performanceArrayList = new ArrayList<>();
        performanceArrayList = companyDao.getPerformanceByUserIdNoComId(userid, comid);
        Collections.sort(performanceArrayList, new Comparator<Performance>() {
            @Override
            public int compare(Performance o1, Performance o2) {
                return o1.comid - o2.comid;
            }
        });
        return performanceArrayList;
    }
    @Override
    public List<Performance> getPerformanceByUserId(Integer userid) {
        List<Performance> performanceArrayList = new ArrayList<>();
        performanceArrayList = companyDao.getPerformanceByUserId(userid);
        Collections.sort(performanceArrayList, new Comparator<Performance>() {
            @Override
            public int compare(Performance o1, Performance o2) {
                return o1.comid - o2.comid;
            }
        });
        return performanceArrayList;
    }
}
