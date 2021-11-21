package com.dhy.ddd.goods.domain;

import com.dhy.ddd.goods.app.GoodsDto;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Title OrderEntity
 * @Description  订单实体
 * @Author lvaolin
 * @Date 2021/11/21 18:39
 **/
@Data
public class GoodsEntity {

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
     * 根据商品ID加载商品信息
     * @return
     */
    public GoodsDto loadByGoodsId(){
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setGoodsId(goodsId);
        goodsDto.setGoodsName("小米电视");
        return goodsDto;
    }

    /**
     * 上架
     * @return
     */
    boolean offline(){
        return true;
    }

    /**
     * 下架
     * @return
     */
    boolean online(){
        return true;
    }
}
