package com.atguigu.gmall.front.feign;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.vo.SkuDetailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rpc/inner/item")
@FeignClient("service-item")
public interface ItemFeignClient {

    //获取商品详情
    @GetMapping("/sku/{skuId}")
    Result<SkuDetailVo> getSkuDetail(@PathVariable("skuId")Long skuId);


}
