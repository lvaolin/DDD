package com.dhy.ddd.goods.app;

import com.dhy.ddd.goods.domain.GoodsEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Title OrderApp
 * @Description  订单application层
 * @Author lvaolin
 * @Date 2021/11/21 18:34
 **/

@Service
public class GoodsApp implements IGoodsApp {

    @Override
    public GoodsDto getGoodsById(String goodsId) {
        System.out.println("商品查询："+goodsId);
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsId(goodsId);
        return goodsEntity.loadByGoodsId();
    }
}
