package com.dhy.ddd.order.http;

import com.dhy.ddd.order.app.IOrderApp;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单相关web入口
 */
@Component
@RestController
public class OrderController {
    @Autowired
    IOrderApp orderApp;

    @RequestMapping("/order/insert")
    @ResponseBody
    public ResultVo insertOrder(@RequestParam("orderId") String orderId, @RequestParam("goodsId") String goodsId) {
        Head head = new Head();

        boolean b = orderApp.insertOrder(orderId, goodsId);
        if (b) {
            head.setCode("0");
            head.setMsg("success");
        }else{
            head.setCode("1");
            head.setMsg("失败原因");
        }
        Body body = new Body();
        body.setMsg("业务数据。。。。");
        ResultVo resultVo = new ResultVo();
        resultVo.setHead(head);
        resultVo.setBody(body);
        return resultVo;
    }

    @Data
    public static class ResultVo{
        Head head;
        Body body;
    }

    @Data
    public static class Head{
         String code;
         String msg;
    }

    @Data
    public static class Body{
        String msg;
    }
}
