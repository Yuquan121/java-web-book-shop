package com.lyy.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:购物车对象
 * @author: Moon
 */

public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap();

    /**
     * 添加商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());

        //之前没添加过
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            //购物车已经有该商品,数量累加
            item.setCount(item.getCount() + 1);
            //更新总价格
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品项
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);

    }

    /**
     * 清空购物车商品
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品数量
     *
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            //更新总价格
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("0");
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    @Test
    public void test(){
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java入门到精通",3,new BigDecimal("1000"),new BigDecimal("100")));
        cart.addItem(new CartItem(1,"java入门到精通",1,new BigDecimal("1000"),new BigDecimal("100")));
        cart.addItem(new CartItem(2,"数据结构和算法",2,new BigDecimal("100"),new BigDecimal("100")));

        System.out.println(cart);
    }
}
