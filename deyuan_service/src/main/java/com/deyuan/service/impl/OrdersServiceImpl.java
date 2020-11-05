package com.deyuan.service.impl;

import com.deyuan.dao.OrdersDao;
import com.deyuan.pojo.Orders;
import com.deyuan.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private OrdersDao ordersDao;


    public List<Orders> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String orderId) throws Exception {
        return ordersDao.findByOrderId(orderId);
    }
}
