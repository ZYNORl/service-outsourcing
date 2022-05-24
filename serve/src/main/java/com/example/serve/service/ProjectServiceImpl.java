package com.example.serve.service;

import com.example.serve.Dao.ProjectDao;
import com.example.serve.bean.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Override
    public void InsertProject(project project) {
        projectDao.InsertProject(project);
    }

    @Override
    public List<project> getProjectById(Integer userid) {
        return projectDao.getProjectById(userid);
    }
}
