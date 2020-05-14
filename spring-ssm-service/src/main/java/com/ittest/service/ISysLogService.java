package com.ittest.service;

import com.ittest.domain.SysLog;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-05-12 21:22
 */
public interface ISysLogService {

    public void save(SysLog sysLog);
    public List<SysLog> findAll();
}
