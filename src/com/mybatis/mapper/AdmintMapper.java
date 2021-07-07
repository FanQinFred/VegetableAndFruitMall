package com.mybatis.mapper;

import com.mybatis.po.Admint;
import com.mybatis.po.AdmintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmintMapper {
    int countByExample(AdmintExample example);

    int deleteByExample(AdmintExample example);

    int insert(Admint record);

    int insertSelective(Admint record);

    List<Admint> selectByExample(AdmintExample example);

    int updateByExampleSelective(@Param("record") Admint record, @Param("example") AdmintExample example);

    int updateByExample(@Param("record") Admint record, @Param("example") AdmintExample example);
}