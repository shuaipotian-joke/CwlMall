package com.cwl.mall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwl.mall.member.entity.UmsMemberLevelEntity;
import com.cwl.mall.member.service.UmsMemberLevelService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.R;



/**
 * 会员等级
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:30:06
 */
@RestController
@RequestMapping("member/umsmemberlevel")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService umsMemberLevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberLevelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		UmsMemberLevelEntity umsMemberLevel = umsMemberLevelService.getById(id);

        return R.ok().put("umsMemberLevel", umsMemberLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UmsMemberLevelEntity umsMemberLevel){
		umsMemberLevelService.save(umsMemberLevel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UmsMemberLevelEntity umsMemberLevel){
		umsMemberLevelService.updateById(umsMemberLevel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberLevelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
