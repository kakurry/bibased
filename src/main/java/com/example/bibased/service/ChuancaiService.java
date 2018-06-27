package com.example.bibased.service;

import com.example.bibased.javabean.ChuancaiMst;
import com.example.bibased.javabean.ChuancaiMstExample;

import java.util.List;

public interface ChuancaiService {
    List<ChuancaiMst> selectByExample(ChuancaiMstExample criteria);

    int countByCriteria(ChuancaiMstExample criteria);

    void insert(ChuancaiMst chuancaiMst);

    void update(ChuancaiMst chuancaiMst);

    void batchDisabled(List<ChuancaiMst> list);
}
