package com.cwl.mall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.mall.common.to.MemberPrice;
import com.cwl.mall.common.to.SkuReductionTo;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.Query;
import com.cwl.mall.coupon.dao.SkuFullReductionDao;
import com.cwl.mall.coupon.entity.MemberPriceEntity;
import com.cwl.mall.coupon.entity.SkuFullReductionEntity;
import com.cwl.mall.coupon.entity.SkuLadderEntity;
import com.cwl.mall.coupon.service.MemberPriceService;
import com.cwl.mall.coupon.service.SkuFullReductionService;
import com.cwl.mall.coupon.service.SkuLadderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {
    @Autowired
    SkuLadderService skuLadderService;

    @Autowired
    MemberPriceService memberPriceService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo skuReductionTo) {
        // 1.保存商品阶梯价格 sms_sku_ladder
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        BeanUtils.copyProperties(skuReductionTo, skuLadderEntity);
        skuLadderEntity.setAddOther(skuReductionTo.getCountStatus());
        if (skuReductionTo.getFullCount() > 0) {
            skuLadderService.save(skuLadderEntity);
        }

        // 2.保存满减信息sms_sku_full_reduction  sms_coupon_spu_relation sms_spu_bounds
        SkuFullReductionEntity skuFullReductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReductionTo, skuFullReductionEntity);
        if (skuFullReductionEntity.getFullPrice().compareTo(new BigDecimal("0")) > 0) {
            save(skuFullReductionEntity);
        }

        // 3.保存会员价格 sms_member_price
        List<MemberPrice> memberPrices = skuReductionTo.getMemberPrice();
        List<MemberPriceEntity> memberPriceEntityList = memberPrices.stream().map(memberPrice -> {
            MemberPriceEntity memberPriceEntity = new MemberPriceEntity();
            memberPriceEntity.setSkuId(skuReductionTo.getSkuId());
            memberPriceEntity.setMemberLevelId(memberPrice.getId());
            memberPriceEntity.setMemberLevelName(memberPrice.getName());
            memberPriceEntity.setMemberPrice(memberPrice.getPrice());
            memberPriceEntity.setAddOther(1);
            return memberPriceEntity;
        }).filter(memberPrice-> memberPrice.getMemberPrice().compareTo(new BigDecimal("0")) > 0).collect(Collectors.toList());
        memberPriceService.saveBatch(memberPriceEntityList);
    }

}
