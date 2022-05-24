package com.example.serve.Dao;

import com.example.serve.bean.project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectDao {
    void InsertProject(project project);
    List<project> getProjectById(Integer userid);
}
