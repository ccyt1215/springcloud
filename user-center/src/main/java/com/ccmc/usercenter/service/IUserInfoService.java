package com.ccmc.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccmc.usercenter.entity.UserInfo;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 陈玉婷
 * @since 2023-01-09
 */
@FeignClient(value = "user-center")
public interface IUserInfoService extends IService<UserInfo> {

    @RequestMapping(value = "/userinfo/test/{message}", method = RequestMethod.GET)
    String test(@PathVariable(value = "message") String message);
}
