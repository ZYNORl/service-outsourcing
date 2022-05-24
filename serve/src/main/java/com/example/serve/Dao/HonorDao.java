package com.example.serve.Dao;

import com.example.serve.bean.honor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HonorDao {
    void insertHonor(honor honor);
    List<honor> getHonorById(Integer userid);
}
