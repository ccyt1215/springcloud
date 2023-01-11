package com.ccmc.ordercenter.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 陈玉婷
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Size(max =  255,message = "超过最大长度[255]")
    private String username;

    @Size(max =  255,message = "超过最大长度[255]")
    private String startStation;

    @Size(max =  255,message = "超过最大长度[255]")
    private String endStation;

    @Size(max =  255,message = "超过最大长度[255]")
    private String openTime;


}
