package com.lyy.Service;

import com.lyy.domain.Cart;

public interface OrderService {
    /**
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart, Integer userId);
}
