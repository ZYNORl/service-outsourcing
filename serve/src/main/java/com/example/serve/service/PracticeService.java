package com.example.serve.service;

import com.example.serve.bean.practice;

import java.util.List;

public interface PracticeService {
    void InsertPractice(practice practice);
    List<practice> getPracticeById(Integer userid);
}
