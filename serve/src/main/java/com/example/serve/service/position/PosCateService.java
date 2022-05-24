package com.example.serve.service.position;

import com.example.serve.bean.position.PosCateSimple;

import java.util.HashMap;
import java.util.List;

public interface PosCateService {
    HashMap<String, Object> getAllSkillByPisitionName(String positionName);
    List<PosCateSimple> getPosCateSimpleListByLevel(Integer level);
    List<PosCateSimple> getPosCateSimpleListByPid(Integer pid);
}
