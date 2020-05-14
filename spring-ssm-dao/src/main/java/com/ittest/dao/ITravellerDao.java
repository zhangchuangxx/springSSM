package com.ittest.dao;

import com.ittest.domain.Member;
import com.ittest.domain.Product;
import com.ittest.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:18
 */
public interface ITravellerDao {
   /* @Select("select * from product")
    List<Member> findAll() throws Exception;*/

    @Select("select * from order_traveller where id in(select travellerId from traveller where orderid = #{id})")
    Traveller findByOrdersId(Integer id) throws Exception;

   /* @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);*/
}
