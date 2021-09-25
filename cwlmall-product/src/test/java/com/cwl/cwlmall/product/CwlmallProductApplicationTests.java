package com.cwl.cwlmall.product;

import com.cwl.cwlmall.product.entity.PmsBrandEntity;
import com.cwl.cwlmall.product.service.PmsBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CwlmallProductApplicationTests {
    @Autowired
    PmsBrandService brandService;

    @Test
    void contextLoads() {
        PmsBrandEntity brandEntity = new PmsBrandEntity();
        brandEntity.setDescript("哈哈1哈");
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
        System.out.println(111);
    }
}
