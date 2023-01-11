package com.ccmc.carinfo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
* <p>
    * 
    * </p>
*
* @author 陈玉婷
* @since 2023-01-11
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class CarInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "car_id", type = IdType.AUTO)
    private Integer id;

    @Size(max =  255,message = "超过最大长度[255]")
    private String startStation;

    @Size(max =  255,message = "超过最大长度[255]")
    private String passStation;

    @Size(max =  255,message = "超过最大长度[255]")
    private String endStation;

    private Integer capacity;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime openTime;

    private Double openFrequency;


}
