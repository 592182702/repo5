package com.deyuan.dao;

import com.deyuan.pojo.Member;
import com.deyuan.pojo.Orders;
import com.deyuan.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select = "com.deyuan.dao.ProductDao.findById")),

    })
    List<Orders> findAll()throws Exception;


    @Select("select * from orders where id=#{orderId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select = "com.deyuan.dao.ProductDao.findById")),
            @Result(property = "member",column = "MEMBERID",javaType = Member.class,one=@One(select = "com.deyuan.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many=@Many(select = "com.deyuan.dao.TravellerDao.findByOrderId")),

    })
    Orders findByOrderId(String orderId) throws Exception;

}
