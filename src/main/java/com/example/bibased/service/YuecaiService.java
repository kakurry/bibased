package com.example.bibased.service;

import com.example.bibased.javabean.YuecaiMst;
import com.example.bibased.javabean.YuecaiMstExample;

import java.util.List;

public interface YuecaiService {
    void batchDisabled(List<YuecaiMst> list);

    void update(YuecaiMst yuecaiMst);

    void insert(YuecaiMst yuecaiMst);

    List<YuecaiMst> selectByExample(YuecaiMstExample criteria);

    int countByCriteria(YuecaiMstExample criteria);
}
