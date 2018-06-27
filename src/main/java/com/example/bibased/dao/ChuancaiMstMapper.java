package com.example.bibased.dao;

import com.example.bibased.javabean.ChuancaiMst;
import com.example.bibased.javabean.ChuancaiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuancaiMstMapper {
    int countByExample(ChuancaiMstExample example);

    int deleteByExample(ChuancaiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(ChuancaiMst record);

    int insertSelective(ChuancaiMst record);

    List<ChuancaiMst> selectByExample(ChuancaiMstExample example);

    ChuancaiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ChuancaiMst record, @Param("example") ChuancaiMstExample example);

    int updateByExample(@Param("record") ChuancaiMst record, @Param("example") ChuancaiMstExample example);

    int updateByPrimaryKeySelective(ChuancaiMst record);

    int updateByPrimaryKey(ChuancaiMst record);
}