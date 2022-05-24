package com.example.serve.service;

import com.example.serve.Dao.HonorDao;
import com.example.serve.bean.honor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HonorServiceImpl implements HonorService {
    @Autowired
    private HonorDao honorDao;
    @Override
    public void insertHonor(honor honor) {
        honorDao.insertHonor(honor);
    }

    @Override
    public List<honor> getHonorById(Integer userid) {
        return honorDao.getHonorById(userid);
    }
}
