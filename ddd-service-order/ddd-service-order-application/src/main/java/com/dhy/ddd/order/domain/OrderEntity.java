package com.dhy.ddd.order.domain;

import com.dhy.ddd.order.domain.Address;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Title OrderEntity
 * @Description  订单实体
 * @Author lvaolin
 * @Date 2021/11/21 18:39
 **/
@Data
public class OrderEntity {
    /**
     * 订单ID
     */
    String orderId;
    /**
     * 商品ID
     */
    String goodsId;
    /**
     * 商品名称
     */
    String goodsName;
    /**
     * 商品单价
     */
    BigDecimal unitPrice;
    /**
     * 数量
     */
    Integer quantity;
    /**
     * 订单合计
     */
    BigDecimal orderAmount;
    /**
     * 收货地址
     */
    Address address;

    public boolean save(){
        //保存入库
        return true;
    }
}
