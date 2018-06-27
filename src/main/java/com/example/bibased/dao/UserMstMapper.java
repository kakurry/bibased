package com.example.bibased.dao;

import com.example.bibased.javabean.UserMst;
import com.example.bibased.javabean.UserMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMstMapper {
    int countByExample(UserMstExample example);

    int deleteByExample(UserMstExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserMst record);

    int insertSelective(UserMst record);

    List<UserMst> selectByExample(UserMstExample example);

    UserMst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserMst record, @Param("example") UserMstExample example);

    int updateByExample(@Param("record") UserMst record, @Param("example") UserMstExample example);

    int updateByPrimaryKeySelective(UserMst record);

    int updateByPrimaryKey(UserMst record);
}