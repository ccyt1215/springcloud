package com.ccmc.carinfo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ccmc.carinfo.entity.CarInfo;
import com.ccmc.carinfo.service.mapper.CarInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈玉婷
 * @since 2023-01-11
 */
@Service
public class CarInfoServiceImpl extends ServiceImpl<CarInfoMapper, CarInfo> implements ICarInfoService {

}
