package com.example.serve.service;

import com.example.serve.Dao.ExtrkillDao;
import com.example.serve.bean.extrkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtrKillServiceImpl implements ExtrkillService {
    @Autowired
    private ExtrkillDao extrkillDao;
    @Override
    public void InsetExtrkill(extrkill extrkill) {
        extrkillDao.InsetExtrkill(extrkill);
    }

    @Override
    public List<extrkill> getKillsById(Integer userid) {
        return extrkillDao.getKillsById(userid);
    }
}
