package com.example.bibased.serviceImple;

import com.example.bibased.dao.JapancaiMstMapper;
import com.example.bibased.javabean.JapancaiMst;
import com.example.bibased.javabean.JapancaiMstExample;
import com.example.bibased.service.JapancaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("japancaiServiceImpl")
public class JapancaiServiceImpl implements JapancaiService {

    @Autowired
    private JapancaiMstMapper japancaiMstMapper;

    @Override
    public void batchDisabled(List<JapancaiMst> list) {
        for(JapancaiMst obj : list){
            japancaiMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public void update(JapancaiMst japancaiMst) {
        japancaiMstMapper.updateByPrimaryKey(japancaiMst);
    }

    @Override
    public void insert(JapancaiMst japancaiMst) {
        japancaiMstMapper.insert(japancaiMst);
    }

    @Override
    public int countByCriteria(JapancaiMstExample criteria) {
        return japancaiMstMapper.countByExample(criteria);
    }

    @Override
    public List<JapancaiMst> selectByExample(JapancaiMstExample criteria) {
        return japancaiMstMapper.selectByExample(criteria);
    }
}
