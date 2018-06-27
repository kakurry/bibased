package com.example.bibased.dao;

import com.example.bibased.javabean.KoreacaiMst;
import com.example.bibased.javabean.KoreacaiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KoreacaiMstMapper {
    int countByExample(KoreacaiMstExample example);

    int deleteByExample(KoreacaiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(KoreacaiMst record);

    int insertSelective(KoreacaiMst record);

    List<KoreacaiMst> selectByExample(KoreacaiMstExample example);

    KoreacaiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") KoreacaiMst record, @Param("example") KoreacaiMstExample example);

    int updateByExample(@Param("record") KoreacaiMst record, @Param("example") KoreacaiMstExample example);

    int updateByPrimaryKeySelective(KoreacaiMst record);

    int updateByPrimaryKey(KoreacaiMst record);
}