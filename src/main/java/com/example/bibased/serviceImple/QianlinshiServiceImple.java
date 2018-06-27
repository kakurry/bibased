package com.example.bibased.serviceImple;

import com.example.bibased.dao.QianlinshiMstMapper;
import com.example.bibased.javabean.QianlinshiMst;
import com.example.bibased.javabean.UserMst;
import com.example.bibased.service.QianlinshiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("qianlinshiServiceImpl")
public class QianlinshiServiceImple implements QianlinshiService {
    @Autowired
    private QianlinshiMstMapper qianlinshiMstMapper;


    @Override
    public void insert(QianlinshiMst qianlinshiMst) {
        qianlinshiMstMapper.insert(qianlinshiMst);
    }

    @Override
    public void delete() {
        qianlinshiMstMapper.delete();
    }

    @Override
    public QianlinshiMst selectqianlinshi() {
        return qianlinshiMstMapper.selectqianlinshi();
    }
}
