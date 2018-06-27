package com.example.bibased.service;

import com.example.bibased.javabean.DianpuMst;
import com.example.bibased.javabean.DianpuMstExample;

import java.util.List;

public interface DianpuService {
    List<DianpuMst> selectByExample(DianpuMstExample criteria);

    int countByCriteria(DianpuMstExample criteria);

    void insert(DianpuMst dianpuMst);

    void update(DianpuMst dianpuMst);

    void batchDisabled(List<DianpuMst> list);
}
