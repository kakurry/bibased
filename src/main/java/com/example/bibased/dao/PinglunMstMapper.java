package com.example.bibased.dao;

import com.example.bibased.javabean.PinglunMst;
import com.example.bibased.javabean.PinglunMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PinglunMstMapper {
    int countByExample(PinglunMstExample example);

    int deleteByExample(PinglunMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(PinglunMst record);

    int insertSelective(PinglunMst record);

    List<PinglunMst> selectByExample(PinglunMstExample example);

    PinglunMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PinglunMst record, @Param("example") PinglunMstExample example);

    int updateByExample(@Param("record") PinglunMst record, @Param("example") PinglunMstExample example);

    int updateByPrimaryKeySelective(PinglunMst record);

    int updateByPrimaryKey(PinglunMst record);

    PinglunMst selectByPeople(String people);
}