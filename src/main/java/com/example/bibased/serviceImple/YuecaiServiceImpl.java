package com.example.bibased.serviceImple;

import com.example.bibased.dao.YuecaiMstMapper;
import com.example.bibased.javabean.YuecaiMst;
import com.example.bibased.javabean.YuecaiMstExample;
import com.example.bibased.service.YuecaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("yuecaiServiceImpl")
public class YuecaiServiceImpl implements YuecaiService {
    @Autowired
    private YuecaiMstMapper yuecaiMstMapper;

    @Override
    public void batchDisabled(List<YuecaiMst> list) {
        for(YuecaiMst obj : list){
            yuecaiMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public void update(YuecaiMst yuecaiMst) {
        yuecaiMstMapper.updateByPrimaryKey(yuecaiMst);
    }

    @Override
    public void insert(YuecaiMst yuecaiMst) {
        yuecaiMstMapper.insert(yuecaiMst);
    }

    @Override
    public List<YuecaiMst> selectByExample(YuecaiMstExample criteria) {
        return yuecaiMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(YuecaiMstExample criteria) {
        return yuecaiMstMapper.countByExample(criteria);
    }
}
