package com.ittest.service.impl;

import com.github.pagehelper.PageHelper;
import com.ittest.dao.IUserDao;
import com.ittest.domain.Role;
import com.ittest.domain.UserInfo;
import com.ittest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张闯
 * @create 2020-05-08 10:42
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
   @Autowired
    private IUserDao userDao;

   //密码加密
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),getRoles(userInfo.getRoles()));
        return user;
    }
    //将角色拼接成合法的
    public List<SimpleGrantedAuthority> getRoles(List<Role> roles){
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role r: roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(Integer pageNum,Integer size){
        PageHelper.startPage(pageNum,size);
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userDao.findById(id);
    }



   /* public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123");
        System.out.println(encode);


    }*/
}
