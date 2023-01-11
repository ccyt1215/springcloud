package com.ccmc.carinfo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.ccmc.carinfo.entity.CarInfo;
import com.ccmc.carinfo.service.ICarInfoService;
import com.ccmc.carinfo.util.Result;
import com.ccmc.carinfo.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
* Created by 陈玉婷 on 2023/01/11.
*/
@RestController
@RequestMapping("/carinfo")
@Api(tags = "产商品中心")
public class CarInfoController {
    @Resource
    private ICarInfoService carInfoService;

    @ApiOperation(value = "车次新增")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody @Valid CarInfo carInfo) {
        carInfoService.save(carInfo);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "车次删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestBody CarInfo carInfo) {
        carInfoService.removeById(carInfo.getId());
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "车次修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody CarInfo carInfo) {
        carInfoService.updateById(carInfo);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "查看车次细节")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@RequestParam Integer id) {
        CarInfo carInfo = carInfoService.getById(id);
        return ResultGenerator.genSuccessResult(carInfo);
    }

    @ApiOperation(value = "车次列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CarInfo> list = carInfoService.list();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "条件查询车次")
    @RequestMapping(value = "/queryByCond", method = RequestMethod.POST)
    public Result queryByCond(@RequestBody CarInfo carInfo,@RequestParam String pageSize,@RequestParam String pageNum) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<CarInfo> list = carInfoService.list(new QueryWrapper<>(carInfo));
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "导入Excel，本实验不需要该接口")
    @RequestMapping(value = "/importExcelData", method = RequestMethod.POST)
    @Transactional
    public Result importExcelData(@RequestBody List<CarInfo> carInfos) {
        carInfoService.saveBatch(carInfos);
        return ResultGenerator.genSuccessResult();
    }
}
