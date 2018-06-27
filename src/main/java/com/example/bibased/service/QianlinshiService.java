package com.example.bibased.service;

import com.example.bibased.javabean.QianlinshiMst;
import com.example.bibased.javabean.UserMst;

public interface QianlinshiService {

    void insert(QianlinshiMst qianlinshiMst);

    void delete();

    QianlinshiMst selectqianlinshi();
}
