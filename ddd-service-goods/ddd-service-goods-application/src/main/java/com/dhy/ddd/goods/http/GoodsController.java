package com.dhy.ddd.goods.http;

import com.dhy.ddd.goods.app.GoodsDto;
import com.dhy.ddd.goods.app.IGoodsApp;
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
public class GoodsController {
    @Autowired
    IGoodsApp goodsApp;

    @RequestMapping("/goods/query")
    @ResponseBody
    public ResultVo goodQuery(@RequestParam("goodsId") String goodsId) {
        Head head = new Head();

        GoodsDto goodsDto = goodsApp.getGoodsById(goodsId);
        head.setCode("0");
        head.setMsg("success");
        Body body = new Body();
        body.setMsg(goodsDto.toString());
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
