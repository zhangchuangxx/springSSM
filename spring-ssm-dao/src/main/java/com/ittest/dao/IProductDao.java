package com.ittest.dao;

import com.ittest.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:18
 */
public interface IProductDao {
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Select("select * from product where id = #{id}")
    Product findById(Integer id) throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
