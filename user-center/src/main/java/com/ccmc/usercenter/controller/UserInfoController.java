package com.ccmc.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccmc.usercenter.entity.UserInfo;
import com.ccmc.usercenter.service.IUserInfoService;
import com.ccmc.usercenter.util.Result;
import com.ccmc.usercenter.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import feign.RequestLine;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
* Created by 陈玉婷 on 2023/01/09.
*/
@Api("用户中心")
@RestController
@RequestMapping(method = RequestMethod.GET, value = "/userinfo")
public class UserInfoController {
    @Resource
    private RestTemplate restTemplate;
    //调用订单服务端的ip+端口号
    public static final  String PAYMENT_URL = "http://localhost:8002";

    @RequestMapping(value = "/test/{message}", method = RequestMethod.GET)
    //@GetMapping("/test/{message}")
    public String test(@PathVariable(value = "message") String message){
        System.out.println("-----------------------进入了test");
        return message;
    }

    @Resource
    private IUserInfoService userInfoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody @Valid UserInfo userInfo) {

        userInfoService.save(userInfo);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestBody UserInfo userInfo) {
        userInfoService.removeById(userInfo.getId());
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody UserInfo userInfo) {
        userInfoService.updateById(userInfo);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@RequestParam Integer id) {
        UserInfo userInfo = userInfoService.getById(id);
        return ResultGenerator.genSuccessResult(userInfo);
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserInfo> list = userInfoService.list();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/queryByCond", method = RequestMethod.POST)
    public Result queryByCond(@RequestBody UserInfo userInfo,@RequestParam String pageSize,@RequestParam String pageNum) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<UserInfo> list = userInfoService.list(new QueryWrapper<>(userInfo));
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/importExcelData", method = RequestMethod.POST)
    @Transactional
    public Result importExcelData(@RequestBody List<UserInfo> userInfos) {
        userInfoService.saveBatch(userInfos);
        return ResultGenerator.genSuccessResult();
    }
}
