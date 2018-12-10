package com.example.bibased.service;

import com.example.bibased.javabean.GuanliyuanuserMst;
import com.example.bibased.javabean.GuanliyuanuserMstExample;

import java.util.Date;
import java.util.List;

public interface GuanliyuanService {
    public  int yanchongByname(GuanliyuanuserMstExample criteria);

    public void insert(GuanliyuanuserMst gly);

    int countByCriteria(GuanliyuanuserMstExample criteria);

    void batchDisabled(List<GuanliyuanuserMst> list);

    void update(GuanliyuanuserMst gly);

    List<GuanliyuanuserMst> selectByExample(GuanliyuanuserMstExample criteria);

    int selectBynameAndpassword(GuanliyuanuserMstExample criteria);

}
