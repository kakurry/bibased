package com.example.bibased.dao;

import com.example.bibased.javabean.YuecaiMst;
import com.example.bibased.javabean.YuecaiMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface YuecaiMstMapper {
    int countByExample(YuecaiMstExample example);

    int deleteByExample(YuecaiMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(YuecaiMst record);

    int insertSelective(YuecaiMst record);

    List<YuecaiMst> selectByExample(YuecaiMstExample example);

    YuecaiMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YuecaiMst record, @Param("example") YuecaiMstExample example);

    int updateByExample(@Param("record") YuecaiMst record, @Param("example") YuecaiMstExample example);

    int updateByPrimaryKeySelective(YuecaiMst record);

    int updateByPrimaryKey(YuecaiMst record);
}