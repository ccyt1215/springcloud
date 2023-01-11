package com.ccmc.usercenter.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccmc.usercenter.entity.UserInfo;
import com.ccmc.usercenter.service.mapper.UserInfoMapper;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈玉婷
 * @since 2023-01-09
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Override
    public String test(String message) {
        System.out.println("---------------------------进入了test方法的service实现类");
        return message;
    }
}
