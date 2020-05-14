package com.ittest.service;

import com.ittest.domain.Product;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:17
 */
public interface IProductService {
    List<Product> findAll() throws Exception;
    void save(Product product);
}
