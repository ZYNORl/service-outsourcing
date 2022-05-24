package com.example.serve.Dao;

import com.example.serve.bean.position.PosCateSimple;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface PositionDao {
    @MapKey("skill")
    HashMap<String,Object> getAllSkillByPisitionName(String positionName);
    List<PosCateSimple> getPosCateSimpleListByLevel(Integer level);
    List<PosCateSimple> getPosCateSimpleListByPid(Integer pid);
}
