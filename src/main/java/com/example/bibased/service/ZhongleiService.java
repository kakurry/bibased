package com.example.bibased.service;

import com.example.bibased.javabean.ZhongleiMst;
import com.example.bibased.javabean.ZhongleiMstExample;

import java.util.List;

public interface ZhongleiService {
    List<ZhongleiMst> selectByExample(ZhongleiMstExample criteria);

    int countByCriteria(ZhongleiMstExample criteria);

    void update(ZhongleiMst zhongleiMst);

    void insert(ZhongleiMst zhongleiMst);

    void batchDisabled(List<ZhongleiMst> list);
}
