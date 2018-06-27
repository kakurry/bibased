package com.example.bibased.serviceImple;

import com.example.bibased.dao.PinglunMstMapper;
import com.example.bibased.javabean.DianpuMst;
import com.example.bibased.javabean.PinglunMst;
import com.example.bibased.javabean.PinglunMstExample;
import com.example.bibased.service.PinglunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pinglunServiceImpl")
public class PinglunServiceImple implements PinglunService {
    @Autowired
    private PinglunMstMapper pinglunMstMapper;

    @Override
    public int countPinglun(PinglunMstExample criteria) {
        return pinglunMstMapper.countByExample(criteria);
    }

    @Override
    public boolean insert(PinglunMst pinglunMst) {
        pinglunMstMapper.insert(pinglunMst);
        return true;
    }

    @Override
    public boolean update(PinglunMst pinglunMst) {
        pinglunMstMapper.updateByPrimaryKey(pinglunMst);
        return true;
    }

    @Override
    public PinglunMst selectCunZai(String people) {
        return pinglunMstMapper.selectByPeople(people);
    }

    @Override
    public List<PinglunMst> selectByExample(PinglunMstExample criteria) {
        return pinglunMstMapper.selectByExample(criteria);
    }

    @Override
    public int countPinglunALL(PinglunMstExample criteria) {
        return pinglunMstMapper.countByExample(criteria);
    }

    @Override
    public int countByCriteria(PinglunMstExample criteria) {
        return pinglunMstMapper.countByExample(criteria);
    }

    @Override
    public void batchDisabled(List<PinglunMst> list) {
        for(PinglunMst obj : list){
            pinglunMstMapper.deleteByPrimaryKey(obj.getId());
        }
    }


}
