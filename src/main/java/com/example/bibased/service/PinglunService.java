package com.example.bibased.service;

import com.example.bibased.javabean.PinglunMst;
import com.example.bibased.javabean.PinglunMstExample;

import java.util.List;

public interface PinglunService {
    int countPinglun(PinglunMstExample criteria);

    boolean insert(PinglunMst pinglunMst);

    boolean update(PinglunMst pinglunMst);


    PinglunMst selectCunZai(String people);

    List<PinglunMst> selectByExample(PinglunMstExample criteria);

    int countPinglunALL(PinglunMstExample criteria);

    int countByCriteria(PinglunMstExample criteria);

    void batchDisabled(List<PinglunMst> list);
}
