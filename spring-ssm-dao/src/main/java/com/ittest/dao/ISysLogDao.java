package com.ittest.dao;

import com.ittest.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-05-12 21:13
 */
public interface ISysLogDao {
    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog);

    @Select("select * from sysLog")
    public List<SysLog> findAll();
}
