package com.example.bibased.service;

import com.example.bibased.javabean.GuanliyuanuserMst;
import com.example.bibased.javabean.LingshiMst;

import java.util.List;

public interface LingshiService {

    void insert(LingshiMst lingshiMst);

    void delete();

    LingshiMst select();
}
