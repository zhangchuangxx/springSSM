package com.ittest.dao;

import com.ittest.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-05-08 10:56
 */
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ittest.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    public List<UserInfo> findAll();

    @Insert("insert into users(username,email,password,phoneNum,status) values(#{username},#{email},#{password},#{phoneNum},#{status})")
    public  void save(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ittest.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(Integer id);
}
