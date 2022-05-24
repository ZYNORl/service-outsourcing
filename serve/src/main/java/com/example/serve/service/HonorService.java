package com.example.serve.service;

import com.example.serve.bean.honor;

import java.util.List;

public interface HonorService {
    void insertHonor(honor honor);
    List<honor> getHonorById(Integer userid);
}
