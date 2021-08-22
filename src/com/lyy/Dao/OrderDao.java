package com.lyy.Dao;

import com.lyy.domain.Order;

import java.util.List;

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


    /**
     *  查询当前用户的所有订单信息
     * @param userId 用户ID
     * @return       当前用户的所有订单信息
     */
    List<Order> queryOrdersByUserId(Integer userId);

    /**
     * 管理员查询全部订单
     * @return
     */
    List<Order> queryOrders();

    /**
     * 更新订单的状态
     * @param orderId   订单号
     * @param status    状态
     */
    void updateStatus(String orderId,Integer status);


}
