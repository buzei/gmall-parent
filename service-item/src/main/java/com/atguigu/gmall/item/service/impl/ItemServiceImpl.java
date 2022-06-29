package com.atguigu.gmall.item.service.impl;
import java.math.BigDecimal;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.vo.CategoryView;

import com.atguigu.gmall.item.service.ItemService;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
public class ItemServiceImpl implements ItemService  {


    @Override
    public SkuDetailVo getSkuDetail(Long skuId) {
        SkuDetailVo vo = new SkuDetailVo();
        //sku所在的分类
        vo.setCategoryView(new CategoryView());
        vo.setSkuInfo(new SkuInfo());
        vo.setPrice(new BigDecimal("0"));
        vo.setSpuSaleAttrList(new Object());
        vo.setValueSkuJson("");


        return vo;
    }
}
