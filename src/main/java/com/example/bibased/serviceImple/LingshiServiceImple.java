package com.example.bibased.serviceImple;

import com.example.bibased.dao.LingshiMstMapper;
import com.example.bibased.javabean.GuanliyuanuserMst;
import com.example.bibased.javabean.LingshiMst;
import com.example.bibased.service.LingshiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lingshiServiceImpl")
public class LingshiServiceImple implements LingshiService {
    @Autowired
    private LingshiMstMapper lingshiMstMapper;

    @Override
    public void insert(LingshiMst lingshiMst) {
        lingshiMstMapper.insert(lingshiMst);
    }

    @Override
    public void delete() {
        lingshiMstMapper.delete();
    }

    @Override
    public LingshiMst select() {
        return lingshiMstMapper.selectLinshi();
    }
}
