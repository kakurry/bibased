package com.example.bibased.service;

import com.example.bibased.javabean.JapancaiMst;
import com.example.bibased.javabean.JapancaiMstExample;

import java.util.List;

public interface JapancaiService {
    void batchDisabled(List<JapancaiMst> list);

    void update(JapancaiMst japancaiMst);

    void insert(JapancaiMst japancaiMst);

    int countByCriteria(JapancaiMstExample criteria);

    List<JapancaiMst> selectByExample(JapancaiMstExample criteria);
}
