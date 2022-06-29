package com.atguigu.gmall.model.vo;

import com.atguigu.gmall.model.product.SkuInfo;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuDetailVo {
    //sku对应的三级分类
    private CategoryView categoryView;
    //sku信息
    private SkuInfo skuInfo;
    //sku价格
    private BigDecimal price;

    private Object spuSaleAttrList;

    private String valueSkuJson;


}
