package com.example.bibased.dao;

import com.example.bibased.javabean.HuipingMst;
import com.example.bibased.javabean.HuipingMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HuipingMstMapper {
    int countByExample(HuipingMstExample example);

    int deleteByExample(HuipingMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(HuipingMst record);

    int insertSelective(HuipingMst record);

    List<HuipingMst> selectByExample(HuipingMstExample example);

    HuipingMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HuipingMst record, @Param("example") HuipingMstExample example);

    int updateByExample(@Param("record") HuipingMst record, @Param("example") HuipingMstExample example);

    int updateByPrimaryKeySelective(HuipingMst record);

    int updateByPrimaryKey(HuipingMst record);
}