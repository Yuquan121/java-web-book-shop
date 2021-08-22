package com.lyy.Dao.impl;

import com.lyy.Dao.BasicDao;
import com.lyy.Dao.OrderDao;
import com.lyy.domain.Order;

import java.util.List;

/**
 * @description:
 * @author: Moon
 */

public class OrderDaoImpl extends BasicDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "select order_id,create_time,price,status,userid from t_order where userid = ? order by create_time";
        return queryMult(sql,Order.class,userId);
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select order_id,create_time,price,status,userid from t_order";
        return queryMult(sql,Order.class);
    }

    @Override
    public void updateStatus(String orderId, Integer status) {
        String sql="update t_order set status = ? where orderId = ?";
        update(sql,status,orderId);
    }

}
