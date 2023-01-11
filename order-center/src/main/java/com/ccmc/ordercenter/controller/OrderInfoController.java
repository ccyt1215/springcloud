package com.ccmc.ordercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.ccmc.ordercenter.entity.OrderInfo;
import com.ccmc.ordercenter.service.IOrderInfoService;
import com.ccmc.ordercenter.util.Result;
import com.ccmc.ordercenter.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


/**
* Created by 陈玉婷 on 2023/01/09.
*/
@RestController
@RequestMapping("/orderinfo")
@RefreshScope //动态刷新
@Api(tags = "订单中心")
public class OrderInfoController {
    @Value("${config.info}")
    private String info;     //该属性值是从nacos配置中心拉取到的配置

    @GetMapping("/testConfig")
    public String testConfig(){
        return info;
    }



    @Resource
    private IOrderInfoService orderInfoService;

    @ApiOperation("新增订单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody @Valid OrderInfo orderInfo) {
        orderInfoService.save(orderInfo);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestBody OrderInfo orderInfo) {
        orderInfoService.removeById(orderInfo.getId());
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("更新订单")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody OrderInfo orderInfo) {
        orderInfoService.updateById(orderInfo);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("查看订单细节")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@RequestParam Integer id) {
        OrderInfo orderInfo = orderInfoService.getById(id);
        return ResultGenerator.genSuccessResult(orderInfo);
    }

    @ApiOperation("列出所有订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OrderInfo> list = orderInfoService.list();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation("条件查询订单")
    @RequestMapping(value = "/queryByCond", method = RequestMethod.POST)
    public Result queryByCond(@RequestBody OrderInfo orderInfo,@RequestParam String pageSize,@RequestParam String pageNum) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<OrderInfo> list = orderInfoService.list(new QueryWrapper<>(orderInfo));
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "导入Excel，本实验不需要该接口")
    @RequestMapping(value = "/importExcelData", method = RequestMethod.POST)
    @Transactional
    public Result importExcelData(@RequestBody List<OrderInfo> orderInfos) {
        orderInfoService.saveBatch(orderInfos);
        return ResultGenerator.genSuccessResult();
    }
}
