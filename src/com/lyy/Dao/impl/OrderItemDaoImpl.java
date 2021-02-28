package com.lyy.Dao.impl;

import com.lyy.Dao.BasicDao;
import com.lyy.Dao.OrderItemDao;
import com.lyy.domain.OrderItem;

public class OrderItemDaoImpl extends BasicDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
