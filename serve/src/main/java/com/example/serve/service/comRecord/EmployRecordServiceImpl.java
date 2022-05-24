package com.example.serve.service.comRecord;

import com.example.serve.Dao.CompanyDao;
import com.example.serve.bean.company.EmployRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployRecordServiceImpl implements EmployRecordService{
    @Autowired
    private CompanyDao companyDao;
    @Override
    public List<Integer> getEmployRecordAll(Integer userid) {
        List< Integer > list = new ArrayList<>();
        for(EmployRecord employRecord : companyDao.getEmployRecordAll(userid)){
            list.add(employRecord.getComid());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            //在实现Comparator接口的compare()方法的时候，return 1代表大于，return -1代表小于。然后根据返回值来进行排序。
            public int compare(Integer o1, Integer o2) {
                if(01 > 02){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        return list;
    }

    @Override
    public List<Integer> getEmployRecordNoComId(Integer userid, Integer comid) {
        List< Integer > list = new ArrayList<>();
        for(EmployRecord employRecord : companyDao.getEmployRecordNoComId(userid,comid)){
            list.add(employRecord.getComid());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            //在实现Comparator接口的compare()方法的时候，return 1代表大于，return -1代表小于。然后根据返回值来进行排序。
            public int compare(Integer o1, Integer o2) {
                if(01 > 02){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        return list;
    }
}
