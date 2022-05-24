package com.example.serve.Dao;

import com.example.serve.bean.practice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PracticeDao {
    void InsertPractice(practice practice);
    List<practice> getPracticeById(Integer userid);
}
