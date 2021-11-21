package com.dhy.ddd.goods.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title Goods
 * @Description
 * @Author lvaolin
 * @Date 2021/11/21 20:30
 **/
@Data
public class GoodsDto  implements Serializable {
    String goodsId;
    String goodsName;
}
