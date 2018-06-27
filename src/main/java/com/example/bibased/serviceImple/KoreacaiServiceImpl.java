package com.example.bibased.serviceImple;

import com.example.bibased.dao.KoreacaiMstMapper;
import com.example.bibased.javabean.KoreacaiMst;
import com.example.bibased.javabean.KoreacaiMstExample;
import com.example.bibased.service.KoreacaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("koreacaiServiceImpl")
public class KoreacaiServiceImpl implements KoreacaiService {
    @Autowired
    private KoreacaiMstMapper koreacaiMstMapper;

    @Override
    public void batchDisabled(List<KoreacaiMst> list) {
        for(KoreacaiMst obj : list){
            koreacaiMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public void update(KoreacaiMst koreacaiMst) {
        koreacaiMstMapper.updateByPrimaryKey(koreacaiMst);
    }

    @Override
    public void insert(KoreacaiMst koreacaiMst) {
        koreacaiMstMapper.insert(koreacaiMst);
    }

    @Override
    public int countByCriteria(KoreacaiMstExample criteria) {
        return koreacaiMstMapper.countByExample(criteria);
    }

    @Override
    public List<KoreacaiMst> selectByExample(KoreacaiMstExample criteria) {
        return koreacaiMstMapper.selectByExample(criteria);
    }
}
