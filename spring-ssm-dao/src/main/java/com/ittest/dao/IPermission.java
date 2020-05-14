package com.ittest.dao;

import com.ittest.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-05-10 13:11
 */
public interface IPermission {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findByRoleid(Integer id);
}
