package com.example.bibased.serviceImple;

import com.example.bibased.dao.ChuancaiMstMapper;
import com.example.bibased.javabean.ChuancaiMst;
import com.example.bibased.javabean.ChuancaiMstExample;
import com.example.bibased.service.ChuancaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chuancaiServiceImpl")
public class ChuancaiServiceImple implements ChuancaiService {
    @Autowired
    private ChuancaiMstMapper chuancaiMstMapper;

    @Override
    public List<ChuancaiMst> selectByExample(ChuancaiMstExample criteria) {
        return chuancaiMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(ChuancaiMstExample criteria) {
        return chuancaiMstMapper.countByExample(criteria);
    }

    @Override
    public void insert(ChuancaiMst chuancaiMst) {
        chuancaiMstMapper.insert(chuancaiMst);
    }

    @Override
    public void update(ChuancaiMst chuancaiMst) {
        chuancaiMstMapper.updateByPrimaryKey(chuancaiMst);
    }

    @Override
    public void batchDisabled(List<ChuancaiMst> list) {
        for(ChuancaiMst obj : list){
            chuancaiMstMapper.deleteByPrimaryKey(obj.getId());
        }

    }
}
