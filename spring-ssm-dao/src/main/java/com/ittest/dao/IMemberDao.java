package com.ittest.dao;

import com.ittest.domain.Member;
import com.ittest.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:18
 */
public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    Member findById(Integer id) throws Exception;

   /* @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);*/
}
