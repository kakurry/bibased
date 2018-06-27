package com.example.bibased.dao;

import com.example.bibased.javabean.GuanliyuanuserMst;
import com.example.bibased.javabean.LingshiMst;
import com.example.bibased.javabean.LingshiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LingshiMstMapper {
    int countByExample(LingshiMstExample example);

    int deleteByExample(LingshiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(LingshiMst record);

    int insertSelective(LingshiMst record);

    List<LingshiMst> selectByExample(LingshiMstExample example);

    LingshiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LingshiMst record, @Param("example") LingshiMstExample example);

    int updateByExample(@Param("record") LingshiMst record, @Param("example") LingshiMstExample example);

    int updateByPrimaryKeySelective(LingshiMst record);

    int updateByPrimaryKey(LingshiMst record);

    void delete();

    LingshiMst selectLinshi();
}