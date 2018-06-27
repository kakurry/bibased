package com.example.bibased.serviceImple;
import com.example.bibased.dao.UserMstMapper;
import com.example.bibased.javabean.UserMst;
import com.example.bibased.javabean.UserMstExample;
import com.example.bibased.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImple implements UserService {
    @Autowired
    private UserMstMapper userMstMapper;

    @Override
    public int selectByusernameAndpassword(UserMstExample criteria) {
        return userMstMapper.countByExample(criteria);
    }

    @Override
    public boolean insert(UserMst userMst) {
        userMstMapper.insert(userMst);
        return true;
    }

    @Override
    public List<UserMst> selectByExample(UserMstExample criteria) {
        return userMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(UserMstExample criteria) {
        return userMstMapper.countByExample(criteria);
    }

    @Override
    public void update(UserMst userMst) {
        userMstMapper.updateByPrimaryKey(userMst);
    }


    @Override
    public void batchDisabled(List<UserMst> list) {
        for (UserMst obj : list) {
            userMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }
}
