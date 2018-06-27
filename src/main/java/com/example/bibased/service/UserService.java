package com.example.bibased.service;

import com.example.bibased.javabean.UserMst;
import com.example.bibased.javabean.UserMstExample;

import java.util.List;

public interface UserService {

    public int selectByusernameAndpassword(UserMstExample criteria);

   public boolean insert(UserMst userMst);

    List<UserMst> selectByExample(UserMstExample criteria);

    int countByCriteria(UserMstExample criteria);

    void update(UserMst userMst);

    void batchDisabled(List<UserMst> list);
}
