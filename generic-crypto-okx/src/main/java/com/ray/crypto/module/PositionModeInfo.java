package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX持仓模式信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PositionModeInfo {
    
    /** 
     * 持仓模式
     * net_mode：单向持仓
     * long_short_mode：双向持仓
     */
    private String posMode;
}