package com.dhy.ddd.order.app;

import com.dhy.ddd.goods.app.GoodsDto;
import com.dhy.ddd.goods.app.IGoodsApp;
import com.dhy.ddd.order.domain.Address;
import com.dhy.ddd.order.domain.OrderEntity;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

/**
 * @Title OrderApp
 * @Description  订单application层
 * @Author lvaolin
 * @Date 2021/11/21 18:34
 **/

@Service
public class OrderApp implements IOrderApp {

    @DubboReference
    IGoodsApp goodsApp;

    @Override
    public boolean insertOrder(String orderId, String goodsId) {

        //根据goodsId  RPC查询商品信息
        GoodsDto goods = goodsApp.getGoodsById(goodsId);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderId);
        orderEntity.setGoodsId(goodsId);
        orderEntity.setGoodsName(goods.getGoodsName());

        orderEntity.setQuantity(2);
        orderEntity.setUnitPrice(new BigDecimal(1.5));
        orderEntity.setOrderAmount(new BigDecimal(1.5*2));
        orderEntity.setAddress(new Address());

        boolean save = orderEntity.save();

        System.out.println(orderEntity.toString());
        //创建待支付信息

        return save;
    }
}
