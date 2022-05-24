package com.example.serve.service;

import com.example.serve.bean.project;

import java.util.List;

public interface ProjectService {
    void InsertProject(project project);
    List<project> getProjectById(Integer userid);
}
