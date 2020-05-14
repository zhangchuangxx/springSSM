package com.ittest.controller;

import com.github.pagehelper.PageInfo;
import com.ittest.domain.UserInfo;
import com.ittest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-05-09 18:02
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/findAll.do")
    public ModelAndView fandAll(@RequestParam(value = "page",required = true,defaultValue = "1")Integer pageNum,
                                @RequestParam(value = "size",required = true,defaultValue = "10")Integer size){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> all = userService.findAll(pageNum, size);
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(all);
        mv.addObject("pageInfo", userInfoPageInfo);
        mv.setViewName("users-list-page");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);

        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id){
        ModelAndView mv = new ModelAndView();
        UserInfo byId = userService.findById(id);
        mv.addObject("user",byId);
        mv.setViewName("user-show");
        return mv;

    }

}
