package com.example.bibased.dao;

import com.example.bibased.javabean.QianlinshiMst;
import com.example.bibased.javabean.QianlinshiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QianlinshiMstMapper {
    int countByExample(QianlinshiMstExample example);

    int deleteByExample(QianlinshiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(QianlinshiMst record);

    int insertSelective(QianlinshiMst record);

    List<QianlinshiMst> selectByExample(QianlinshiMstExample example);

    QianlinshiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") QianlinshiMst record, @Param("example") QianlinshiMstExample example);

    int updateByExample(@Param("record") QianlinshiMst record, @Param("example") QianlinshiMstExample example);

    int updateByPrimaryKeySelective(QianlinshiMst record);

    int updateByPrimaryKey(QianlinshiMst record);

    void delete();

    QianlinshiMst selectqianlinshi();
}