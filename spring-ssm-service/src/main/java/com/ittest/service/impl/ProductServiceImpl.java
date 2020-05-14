package com.ittest.service.impl;

import com.ittest.dao.IProductDao;
import com.ittest.domain.Product;
import com.ittest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:28
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
