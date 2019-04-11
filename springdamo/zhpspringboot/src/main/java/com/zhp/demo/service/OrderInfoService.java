package com.zhp.demo.service;

import com.zhp.demo.bean.OrderInfo;
import com.zhp.demo.dao.OrderDao;
import com.zhp.demo.dao.OrderInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;
    private OrderDao orderDao;



//    public List<OrderInfo> getOrderInfoByOrderOid(Integer oid){
//        return orderInfoDao.findOrerInfoById(orderDao.getOne(oid).getUid(),orderDao.getOne(oid).getPid());
////                .orElse(new OrderInfo(0,0,"null","null",0.0,"null","null"));
//    }

    public OrderInfo getOrderInfoByOrderOid(){
        return orderInfoDao.f();
//                .orElse(new OrderInfo(0,0,"null","null",0.0,"null","null"));
    }
}
