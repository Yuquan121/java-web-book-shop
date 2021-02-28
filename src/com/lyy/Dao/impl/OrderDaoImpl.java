package com.lyy.Dao.impl;

import com.lyy.Dao.BasicDao;
import com.lyy.Dao.OrderDao;
import com.lyy.domain.Order;

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
}
