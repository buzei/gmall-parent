package com.atguigu.gmall.front.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.front.feign.ItemFeignClient;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {

    @Autowired
    ItemFeignClient itemFeignClient;

    @GetMapping("/{skuId}.html")
    private String item(@PathVariable("skuId")Long skuId, Model model){

        Result<SkuDetailVo> skuDetail = itemFeignClient.getSkuDetail(skuId);
        SkuDetailVo data = skuDetail.getData();

        //分类
        model.addAttribute("categoryView",data.getCategoryView());

        //sku信息
        model.addAttribute("skuInfo",data.getSkuInfo());

        //sku价格
        model.addAttribute("price",data.getPrice());

        //spu定于所有的销售属性和值
        model.addAttribute("spuSaleAttrList",data.getSpuSaleAttrList());

        //valueSkuJson
        model.addAttribute("valueSkuJson",data.getValueSkuJson());

        return "item/index";
    }
}
