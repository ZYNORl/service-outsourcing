package com.example.serve.service.comRecord;

import com.example.serve.Dao.CompanyDao;
import com.example.serve.bean.company.Attendance;
import com.example.serve.bean.company.SumAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@Service
public class SumAttendanceServiceImpl implements SumAttendanceService {
    @Autowired
    private CompanyDao companyDao;
    @Override
    public SumAttendance getSumAttendanceByUserIdAndComId(Integer userid, Integer comid) {
        int leavesum=0,latesum=0,cardsum=0,overworksum=0;
        for(Attendance attendance : companyDao.getAttendanceByUserIdAndComId(userid, comid)){
            leavesum += attendance.getLeavenum()!=null?attendance.getLeavenum():0;
            latesum += attendance.getLatenum()!=null?attendance.getLatenum():0;
            cardsum += attendance.getCardnum()!=null?attendance.getCardnum():0;
            overworksum += attendance.getOverworknum()!=null?attendance.getOverworknum():0;
        }
        return new SumAttendance(userid,comid,leavesum,latesum,cardsum,overworksum);
    }

    @Override
    public List<SumAttendance> getSumAttendanceByUserId(Integer userid) {
        List<SumAttendance> sumAttendanceList = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Attendance attendance : companyDao.getSumAttendanceByUserId(userid)){
            treeSet.add(attendance.getComid());
        }
        Iterator<Integer> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            int leavesum=0,latesum=0,cardsum=0,overworksum=0,index = iterator.next();
            for(Attendance attendance : companyDao.getAttendanceByUserIdAndComId(userid,index)){
                leavesum += attendance.getLeavenum()!=null?attendance.getLeavenum():0;
                latesum += attendance.getLatenum()!=null?attendance.getLatenum():0;
                cardsum += attendance.getCardnum()!=null?attendance.getCardnum():0;
                overworksum += attendance.getOverworknum()!=null?attendance.getOverworknum():0;
            }
            sumAttendanceList.add(new SumAttendance(userid,index,leavesum,latesum,cardsum,overworksum));
        }
        return sumAttendanceList;
    }

    @Override
    public List<SumAttendance> getSumAttendanceByUserIdNoComId(Integer userid, Integer comid) {
        List<SumAttendance> sumAttendanceList = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Attendance attendance : companyDao.getSumAttendanceByUserIdNoComId(userid, comid)){
            treeSet.add(attendance.getComid());
        }
        Iterator<Integer> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            int leavesum=0,latesum=0,cardsum=0,overworksum=0,index = iterator.next();
            for(Attendance attendance : companyDao.getAttendanceByUserIdAndComId(userid,index)){
                leavesum += attendance.getLeavenum()!=null?attendance.getLeavenum():0;
                latesum += attendance.getLatenum()!=null?attendance.getLatenum():0;
                cardsum += attendance.getCardnum()!=null?attendance.getCardnum():0;
                overworksum += attendance.getOverworknum()!=null?attendance.getOverworknum():0;
            }
            sumAttendanceList.add(new SumAttendance(userid,index,leavesum,latesum,cardsum,overworksum));
        }
        return sumAttendanceList;
    }
}
