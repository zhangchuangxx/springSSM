package com.ittest.dao;

import com.ittest.domain.Member;
import com.ittest.domain.Order;
import com.ittest.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 张闯
 * @create 2020-04-23 13:18
 */
public interface IOrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id" ),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "com.ittest.dao.IProductDao.findById")),

    })
    List<Order> findAll() throws Exception;

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id" ),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "com.ittest.dao.IProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Member.class,one = @One(select = "com.ittest.dao.IMemberDao.findById")),
            @Result(column = "travellers",property = "travellers",javaType = java.util.List.class,many = @Many(select = "com.ittest.dao.ITravellerDao.findByOrdersId"))
    })
    Order findById(Integer id);

   /* @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);*/
}
