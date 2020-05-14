package com.ittest.service;

import com.ittest.domain.Order;
import com.ittest.domain.Product;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:17
 */
public interface IOrderService {
    List<Order> findAll() throws Exception;
    List<Order> findByPage(Integer page,Integer size) throws Exception;
    Order findById(Integer id);
}
