package com.example.bibased.serviceImple;

import com.example.bibased.dao.ZhongleiMstMapper;
import com.example.bibased.javabean.ZhongleiMst;
import com.example.bibased.javabean.ZhongleiMstExample;
import com.example.bibased.service.ZhongleiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("zhongleiServiceImpl")
public class ZhogleiServiceImple implements ZhongleiService {
    @Autowired
    private ZhongleiMstMapper zhongleiMstMapper;

    @Override
    public List<ZhongleiMst> selectByExample(ZhongleiMstExample criteria) {
        return zhongleiMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(ZhongleiMstExample criteria) {
        return zhongleiMstMapper.countByExample(criteria);
    }

    @Override
    public void update(ZhongleiMst zhongleiMst) {
        zhongleiMstMapper.updateByPrimaryKey(zhongleiMst);
    }

    @Override
    public void insert(ZhongleiMst zhongleiMst) {
        zhongleiMstMapper.insert(zhongleiMst);
    }

    @Override
    public void batchDisabled(List<ZhongleiMst> list) {
        for (ZhongleiMst obj : list) {
            zhongleiMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }
}
