package com.example.bibased.dao;

import com.example.bibased.javabean.ZhongleiMst;
import com.example.bibased.javabean.ZhongleiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhongleiMstMapper {
    int countByExample(ZhongleiMstExample example);

    int deleteByExample(ZhongleiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZhongleiMst record);

    int insertSelective(ZhongleiMst record);

    List<ZhongleiMst> selectByExample(ZhongleiMstExample example);

    ZhongleiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZhongleiMst record, @Param("example") ZhongleiMstExample example);

    int updateByExample(@Param("record") ZhongleiMst record, @Param("example") ZhongleiMstExample example);

    int updateByPrimaryKeySelective(ZhongleiMst record);

    int updateByPrimaryKey(ZhongleiMst record);
}