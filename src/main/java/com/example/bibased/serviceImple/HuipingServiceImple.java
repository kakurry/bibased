package com.example.bibased.serviceImple;

import com.example.bibased.dao.HuipingMstMapper;
import com.example.bibased.javabean.HuipingMst;
import com.example.bibased.javabean.HuipingMstExample;
import com.example.bibased.service.HuipingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("huipingServiceImpl")
public class HuipingServiceImple implements HuipingService {
    @Autowired
    private HuipingMstMapper huipingMstMapper;

    @Override
    public void insert(HuipingMst huipingMst) {
        huipingMstMapper.insert(huipingMst);
    }

    @Override
    public List<HuipingMst> selectByExample(HuipingMstExample criteria) {
        return huipingMstMapper.selectByExample(criteria);
    }
}
