package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX期权激活响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ActivateOptionInfo {
    
    /** 标的指数 */
    private String instFamily;
    
    /** 激活结果 */
    private String result;
}