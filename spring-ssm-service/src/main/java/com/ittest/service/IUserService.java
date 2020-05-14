package com.ittest.service;

import com.ittest.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-05-08 10:42
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(Integer pageNum,Integer size);
    public void save(UserInfo userInfo);
    UserInfo findById(Integer id);
}
