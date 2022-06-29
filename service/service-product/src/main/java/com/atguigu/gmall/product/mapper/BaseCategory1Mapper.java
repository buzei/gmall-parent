package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.vo.CategoryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service
 * @Repository
 * @Component
 */
//所有Mapper组件都要放在Spring容器
//@Mapper
public interface BaseCategory1Mapper extends BaseMapper<BaseCategory1> {


    List<CategoryVo> getCategorys();


}
