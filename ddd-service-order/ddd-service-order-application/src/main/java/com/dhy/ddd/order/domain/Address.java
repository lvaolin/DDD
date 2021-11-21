package com.dhy.ddd.order.domain;

import lombok.Data;

/**
 * @Title Address
 * @Description   值对象
 * @Author lvaolin
 * @Date 2021/11/21 18:42
 **/
@Data
public class Address {
    public String sheng;
    public String shi;
    public String xian;
    public String zhen;
    public String cun;
}
