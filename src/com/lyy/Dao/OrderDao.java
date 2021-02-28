package com.lyy.Dao;

import com.lyy.domain.Order;

/**
 * @author Moon
 */
public interface OrderDao {

    /**
     * 保存订单
     * @param order
     * @return
     */
    public int saveOrder(Order order);
}
