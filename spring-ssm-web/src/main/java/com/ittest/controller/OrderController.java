package com.ittest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ittest.domain.Order;
import com.ittest.domain.Product;
import com.ittest.service.IOrderService;
import com.ittest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:43
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;
   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Order> orders = orderService.findAll();
        mv.addObject("ordersList", orders);
        mv.setViewName("orders-list");
        return mv;
    }*/

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",defaultValue = "1",required = true) Integer page,@RequestParam(name="size",defaultValue = "10",required = true) Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Order> orders = orderService.findByPage(page,size);
        //PageHelper pageHelper = new PageHelper(orders);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        mv.addObject("pageInfo", orderPageInfo);
        mv.setViewName("orders-list-page");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Order byId = orderService.findById(id);
        modelAndView.addObject("orders",byId);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
