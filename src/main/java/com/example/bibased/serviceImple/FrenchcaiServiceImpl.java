package com.example.bibased.serviceImple;

import com.example.bibased.dao.FrenchcaiMstMapper;
import com.example.bibased.dao.JapancaiMstMapper;
import com.example.bibased.javabean.FrenchcaiMst;
import com.example.bibased.javabean.FrenchcaiMstExample;
import com.example.bibased.service.FrenchcaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("frencaiServiceImpl")
public class FrenchcaiServiceImpl implements FrenchcaiService {
    @Autowired
    private FrenchcaiMstMapper frenchcaiMstMapper;

    @Override
    public void batchDisabled(List<FrenchcaiMst> list) {
        for(FrenchcaiMst obj : list){
            frenchcaiMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public void update(FrenchcaiMst frenchcaiMst) {
        frenchcaiMstMapper.updateByPrimaryKey(frenchcaiMst);
    }

    @Override
    public void insert(FrenchcaiMst frenchcaiMst) {
        frenchcaiMstMapper.insert(frenchcaiMst);
    }

    @Override
    public int countByCriteria(FrenchcaiMstExample criteria) {
        return frenchcaiMstMapper.countByExample(criteria);
    }

    @Override
    public List<FrenchcaiMst> selectByExample(FrenchcaiMstExample criteria) {
        return frenchcaiMstMapper.selectByExample(criteria);
    }
}
