package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.SkuAttrValue;
import com.atguigu.gmall.model.product.SkuImage;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SkuSaleAttrValue;
import com.atguigu.gmall.product.mapper.SkuInfoMapper;
import com.atguigu.gmall.product.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lfy
 * @description 针对表【sku_info(库存单元表)】的数据库操作Service实现
 * @createDate 2022-06-21 09:01:27
 */
@Slf4j
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
        implements SkuInfoService {

    @Autowired
    SkuImageService skuImageService;

    @Autowired
    SkuAttrValueService skuAttrValueService;

    @Autowired
    SkuSaleAttrValueService skuSaleAttrValueService;

    @Autowired
    SkuInfoMapper skuInfoMapper;

    @Transactional
    @Override
    public void saveSkuInfo(SkuInfo skuInfo) {
        log.info( "sku信息正在保存: {}",skuInfo );
        //保存sku的基本信息
        save( skuInfo );
        Long skuId = skuInfo.getId();

        //保存sku的图片
        List<SkuImage> imageList = skuInfo.getSkuImageList();
        for (SkuImage image : imageList) {
            image.setSkuId( skuId );
        }
        skuImageService.saveBatch( imageList );


        //保存sku的平台属性
        List<SkuAttrValue> attrValueList = skuInfo.getSkuAttrValueList();
        for (SkuAttrValue value : attrValueList) {
            value.setSkuId( skuId );
        }
        skuAttrValueService.saveBatch( attrValueList );


        //保存sku的销售属性
        List<SkuSaleAttrValue> SaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        for (SkuSaleAttrValue attrValue : SaleAttrValueList) {
            attrValue.setSkuId( skuId );
            attrValue.setSpuId(skuInfo.getSpuId());
        }
        skuSaleAttrValueService.saveBatch(SaleAttrValueList);
        log.info( "sku信息保存完成: 生成的skuid {}",skuId );
    }

    @Override
    public void upSku(Long skuId) {
        skuInfoMapper.updateSaleStatus(skuId,1);

    }

    @Override
    public void downSku(Long skuId) {
        skuInfoMapper.updateSaleStatus(skuId,0);
    }


}




