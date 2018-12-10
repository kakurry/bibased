package com.example.bibased.serviceImple;


import com.example.bibased.dao.GuanliyuanuserMstMapper;
import com.example.bibased.javabean.GuanliyuanuserMst;
import com.example.bibased.javabean.GuanliyuanuserMstExample;
import com.example.bibased.service.GuanliyuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("guanliyuanServiceImpl")
public class GuanliyuanServiceImple implements GuanliyuanService {
    @Autowired
    private GuanliyuanuserMstMapper guanliyuanuserMstMapper;

    @Override
    public int yanchongByname(GuanliyuanuserMstExample criteria) {
        return guanliyuanuserMstMapper.countByExample(criteria);
    }

    @Override
    public void insert(GuanliyuanuserMst gly) {
        guanliyuanuserMstMapper.insert(gly);
    }

    @Override
    public int countByCriteria(GuanliyuanuserMstExample criteria) {
        return guanliyuanuserMstMapper.countByExample(criteria);
    }

    @Override
    public void batchDisabled(List<GuanliyuanuserMst> list) {
        for (GuanliyuanuserMst obj : list) {
            guanliyuanuserMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }

    @Override
    public void update(GuanliyuanuserMst gly) {
        guanliyuanuserMstMapper.updateByPrimaryKey(gly);
    }

    @Override
    public List<GuanliyuanuserMst> selectByExample(GuanliyuanuserMstExample criteria) {
        return guanliyuanuserMstMapper.selectByExample(criteria);
    }

    @Override
    public int selectBynameAndpassword(GuanliyuanuserMstExample criteria) {
        return guanliyuanuserMstMapper.countByExample(criteria);
    }


}
