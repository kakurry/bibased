package com.example.bibased.dao;

import com.example.bibased.javabean.DianpuMst;
import com.example.bibased.javabean.DianpuMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DianpuMstMapper {
    int countByExample(DianpuMstExample example);

    int deleteByExample(DianpuMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(DianpuMst record);

    int insertSelective(DianpuMst record);

    List<DianpuMst> selectByExample(DianpuMstExample example);

    DianpuMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DianpuMst record, @Param("example") DianpuMstExample example);

    int updateByExample(@Param("record") DianpuMst record, @Param("example") DianpuMstExample example);

    int updateByPrimaryKeySelective(DianpuMst record);

    int updateByPrimaryKey(DianpuMst record);
}