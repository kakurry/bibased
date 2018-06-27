package com.example.bibased.serviceImple;

import com.example.bibased.dao.DianpuMstMapper;
import com.example.bibased.javabean.DianpuMst;
import com.example.bibased.javabean.DianpuMstExample;
import com.example.bibased.service.DianpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dianpuServiceImpl")
public class DianpuServiceImple implements DianpuService {
    @Autowired
    private DianpuMstMapper dianpuMstMapper;

    @Override
    public List<DianpuMst> selectByExample(DianpuMstExample criteria) {
        return dianpuMstMapper.selectByExample(criteria);
    }

    @Override
    public int countByCriteria(DianpuMstExample criteria) {
        return dianpuMstMapper.countByExample(criteria);
    }

    @Override
    public void insert(DianpuMst dianpuMst) {
        dianpuMstMapper.insert(dianpuMst);
    }

    @Override
    public void update(DianpuMst dianpuMst) {
        dianpuMstMapper.updateByPrimaryKey(dianpuMst);
    }

    @Override
    public void batchDisabled(List<DianpuMst> list) {
        for(DianpuMst obj : list){
            dianpuMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }
}
