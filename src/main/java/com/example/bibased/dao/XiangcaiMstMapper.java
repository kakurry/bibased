package com.example.bibased.dao;

import com.example.bibased.javabean.XiangcaiMst;
import com.example.bibased.javabean.XiangcaiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface XiangcaiMstMapper {
    int countByExample(XiangcaiMstExample example);

    int deleteByExample(XiangcaiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(XiangcaiMst record);

    int insertSelective(XiangcaiMst record);

    List<XiangcaiMst> selectByExample(XiangcaiMstExample example);

    XiangcaiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") XiangcaiMst record, @Param("example") XiangcaiMstExample example);

    int updateByExample(@Param("record") XiangcaiMst record, @Param("example") XiangcaiMstExample example);

    int updateByPrimaryKeySelective(XiangcaiMst record);

    int updateByPrimaryKey(XiangcaiMst record);
}