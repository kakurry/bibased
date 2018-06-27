package com.example.bibased.service;

import com.example.bibased.javabean.KoreacaiMst;
import com.example.bibased.javabean.KoreacaiMstExample;

import java.util.List;

public interface KoreacaiService {
    void batchDisabled(List<KoreacaiMst> list);

    void update(KoreacaiMst koreacaiMst);

    void insert(KoreacaiMst koreacaiMst);

    int countByCriteria(KoreacaiMstExample criteria);

    List<KoreacaiMst> selectByExample(KoreacaiMstExample criteria);
}
