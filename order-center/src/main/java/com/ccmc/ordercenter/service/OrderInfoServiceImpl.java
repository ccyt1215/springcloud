package com.ccmc.ordercenter.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccmc.ordercenter.entity.OrderInfo;
import com.ccmc.ordercenter.service.mapper.OrderInfoMapper;
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
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

}
