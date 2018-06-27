package com.example.bibased.service;

import com.example.bibased.javabean.XiangcaiMst;
import com.example.bibased.javabean.XiangcaiMstExample;

import java.util.List;

public interface XiangcaiService {
    void batchDisabled(List<XiangcaiMst> list);

    void update(XiangcaiMst xiangcaiMst);

    void insert(XiangcaiMst xiangcaiMst);

    int countByCriteria(XiangcaiMstExample criteria);

    List<XiangcaiMst> selectByExample(XiangcaiMstExample criteria);
}
