package com.example.bibased.dao;

import com.example.bibased.javabean.FrenchcaiMst;
import com.example.bibased.javabean.FrenchcaiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FrenchcaiMstMapper {
    int countByExample(FrenchcaiMstExample example);

    int deleteByExample(FrenchcaiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(FrenchcaiMst record);

    int insertSelective(FrenchcaiMst record);

    List<FrenchcaiMst> selectByExample(FrenchcaiMstExample example);

    FrenchcaiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FrenchcaiMst record, @Param("example") FrenchcaiMstExample example);

    int updateByExample(@Param("record") FrenchcaiMst record, @Param("example") FrenchcaiMstExample example);

    int updateByPrimaryKeySelective(FrenchcaiMst record);

    int updateByPrimaryKey(FrenchcaiMst record);
}