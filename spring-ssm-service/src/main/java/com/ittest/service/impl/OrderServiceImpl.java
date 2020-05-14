package com.ittest.service.impl;

import com.github.pagehelper.PageHelper;
import com.ittest.dao.IOrderDao;
import com.ittest.dao.IProductDao;
import com.ittest.domain.Order;
import com.ittest.domain.Product;
import com.ittest.service.IOrderService;
import com.ittest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:28
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    public List<Order> findAll() throws Exception {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findByPage(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public Order findById(Integer id) {
       return orderDao.findById(id);
    }
}
