package com.example.bibased.dao;

import com.example.bibased.javabean.JapancaiMst;
import com.example.bibased.javabean.JapancaiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JapancaiMstMapper {
    int countByExample(JapancaiMstExample example);

    int deleteByExample(JapancaiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(JapancaiMst record);

    int insertSelective(JapancaiMst record);

    List<JapancaiMst> selectByExample(JapancaiMstExample example);

    JapancaiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JapancaiMst record, @Param("example") JapancaiMstExample example);

    int updateByExample(@Param("record") JapancaiMst record, @Param("example") JapancaiMstExample example);

    int updateByPrimaryKeySelective(JapancaiMst record);

    int updateByPrimaryKey(JapancaiMst record);
}