package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置持仓模式请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class PositionModeRequest {
    
    /** 
     * 持仓模式
     * net_mode：单向持仓
     * long_short_mode：双向持仓
     */
    private String posMode;
}