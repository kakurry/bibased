package com.example.bibased.dao;

import java.util.List;

import com.example.bibased.javabean.GuanliyuanuserMst;
import com.example.bibased.javabean.GuanliyuanuserMstExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuanliyuanuserMstMapper {
    int countByExample(GuanliyuanuserMstExample example);

    int deleteByExample(GuanliyuanuserMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(GuanliyuanuserMst record);

    int insertSelective(GuanliyuanuserMst record);

    List<GuanliyuanuserMst> selectByExample(GuanliyuanuserMstExample example);

    GuanliyuanuserMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GuanliyuanuserMst record, @Param("example") GuanliyuanuserMstExample example);

    int updateByExample(@Param("record") GuanliyuanuserMst record, @Param("example") GuanliyuanuserMstExample example);

    int updateByPrimaryKeySelective(GuanliyuanuserMst record);

    int updateByPrimaryKey(GuanliyuanuserMst record);

}