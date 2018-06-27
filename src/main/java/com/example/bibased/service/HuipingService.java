package com.example.bibased.service;

import com.example.bibased.javabean.HuipingMst;
import com.example.bibased.javabean.HuipingMstExample;

import java.util.List;

public interface HuipingService {
    void insert(HuipingMst huipingMst);

    List<HuipingMst> selectByExample(HuipingMstExample criteria);
}
