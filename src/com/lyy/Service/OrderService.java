package com.lyy.Service;

import com.lyy.domain.Cart;
import com.lyy.domain.Order;


public interface OrderService {
    /**
     * @param cart
     * @param userId
     * @return
     */
    public Order createOrder(Cart cart, Integer userId);


}
