package com.example.serve.service;

import com.example.serve.bean.extrkill;

import java.util.List;

public interface ExtrkillService {
    void InsetExtrkill(extrkill extrkill);
    List<extrkill> getKillsById(Integer userid);
}
