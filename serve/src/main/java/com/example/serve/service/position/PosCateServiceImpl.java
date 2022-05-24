package com.example.serve.service.position;


import com.example.serve.Dao.PositionDao;
import com.example.serve.bean.position.PosCateSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PosCateServiceImpl implements PosCateService {
    @Autowired
    private PositionDao positionDao;

    @Override
    public HashMap<String,Object> getAllSkillByPisitionName(String positionName) {
        return positionDao.getAllSkillByPisitionName(positionName);
    }

    @Override
    public List<PosCateSimple> getPosCateSimpleListByLevel(Integer level) {
        return positionDao.getPosCateSimpleListByLevel(level);
    }

    @Override
    public List<PosCateSimple> getPosCateSimpleListByPid(Integer pid) {
        return positionDao.getPosCateSimpleListByPid(pid);
    }
}
