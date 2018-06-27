package com.example.bibased.service;

import com.example.bibased.javabean.FrenchcaiMst;
import com.example.bibased.javabean.FrenchcaiMstExample;

import java.util.List;

public interface FrenchcaiService {
    void batchDisabled(List<FrenchcaiMst> list);

    void update(FrenchcaiMst frenchcaiMst);

    void insert(FrenchcaiMst frenchcaiMst);

    int countByCriteria(FrenchcaiMstExample criteria);

    List<FrenchcaiMst> selectByExample(FrenchcaiMstExample criteria);
}
