package com.atguigu.gmall.front.feign;


import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.vo.CategoryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/rpc/inner/product")
@FeignClient("service-product")//声明需要调用的微服务
public interface CategoryFeignClient {


    @GetMapping("/categorys/all")
    Result<List<CategoryVo>> getCategorys();
}
