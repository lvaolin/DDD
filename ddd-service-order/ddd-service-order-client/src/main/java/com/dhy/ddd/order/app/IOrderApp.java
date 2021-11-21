package com.dhy.ddd.order.app;

/**
 * @Title IOrderApp
 * @Description
 * @Author lvaolin
 * @Date 2021/11/21 18:32
 **/
public interface IOrderApp {

    public boolean insertOrder(String orderId,String goodsId);
}
