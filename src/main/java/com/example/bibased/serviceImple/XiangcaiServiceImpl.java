package com.example.bibased.serviceImple;

import com.example.bibased.dao.XiangcaiMstMapper;
import com.example.bibased.javabean.XiangcaiMst;
import com.example.bibased.javabean.XiangcaiMstExample;
import com.example.bibased.service.XiangcaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("xiangcaiServiceImpl")
public class XiangcaiServiceImpl implements XiangcaiService {
    @Autowired
    private XiangcaiMstMapper xiangcaiMstMapper;

    @Override
    public void batchDisabled(List<XiangcaiMst> list) {
        for(XiangcaiMst obj : list){
            xiangcaiMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public void update(XiangcaiMst xiangcaiMst) {
        xiangcaiMstMapper.updateByPrimaryKey(xiangcaiMst);
    }

    @Override
    public void insert(XiangcaiMst xiangcaiMst) {
        xiangcaiMstMapper.insert(xiangcaiMst);
    }

    @Override
    public int countByCriteria(XiangcaiMstExample criteria) {
        return xiangcaiMstMapper.countByExample(criteria);
    }

    @Override
    public List<XiangcaiMst> selectByExample(XiangcaiMstExample criteria) {
        return xiangcaiMstMapper.selectByExample(criteria);
    }
}
