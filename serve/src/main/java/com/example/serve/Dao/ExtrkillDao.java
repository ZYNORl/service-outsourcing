package com.example.serve.Dao;

import com.example.serve.bean.extrkill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExtrkillDao {
    void InsetExtrkill(extrkill extrkill);
    List<extrkill> getKillsById(Integer userid);

}
