package com.graduation.ppbs.service;

import com.graduation.ppbs.dao.Order;
import com.graduation.ppbs.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired(required = false)
    private OrderMapper orderMapper;

    public List<Order> queryAllOrder() throws Exception {
        return orderMapper.queryAllOrder();
    }

    public void addOrder(String ordername, String technology, BigDecimal minmoney, Date enddate, Integer committerid) throws Exception {
        orderMapper.addOrder(ordername,technology,minmoney,enddate,committerid);
    }

    public Order queryLatest() throws Exception {
        return orderMapper.queryAllLatest().get(0);
    }

    public List<Map<String, Object>> getOrderAudittype2(Integer committerid) throws Exception {
        return orderMapper.getOrderAudittype2(committerid);
    }

    public List<Map<String, Object>> queryAudit2ByAudittype() throws Exception {
        return orderMapper.queryAudit2ByAudittype();
    }

    public void UpdateOrderAudit(Integer auditid,Integer auditerid,Integer orderid) throws Exception {
        orderMapper.UpdateOrderAudit(auditid,auditerid,orderid);
    }

    public Order getOrderByOrderid(Integer orderid) throws Exception {
        return orderMapper.getOrderByOrderid(orderid);
    }

    public void UpdateOrder(String ordername,String technology,BigDecimal minmoney,Date enddate, Integer orderid) throws Exception {
        orderMapper.UpdateOrder(ordername,technology,minmoney,enddate,orderid);
    }

    public List<Order> getBiddingList() throws Exception {
        return orderMapper.getBiddingList();
    }

    public List<Map<String, Object>> getApplicant(Integer orderid) throws Exception {
        return orderMapper.getApplicant(orderid);
    }

    public void UpdateOrderMaxmoney(BigDecimal money,Integer orderid) throws Exception {
        orderMapper.UpdateOrderMaxmoney(money,orderid);
    }
}
