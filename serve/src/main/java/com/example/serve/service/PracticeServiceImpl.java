package com.example.serve.service;

import com.example.serve.Dao.PracticeDao;
import com.example.serve.bean.practice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {
    @Autowired
    private PracticeDao practiceDao;
    @Override
    public void InsertPractice(practice practice) {
        practiceDao.InsertPractice(practice);
    }

    @Override
    public List<practice> getPracticeById(Integer userid) {
        return practiceDao.getPracticeById(userid);
    }
}
