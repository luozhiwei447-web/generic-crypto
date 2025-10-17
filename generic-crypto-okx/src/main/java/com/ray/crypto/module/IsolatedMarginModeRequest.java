package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX逐仓交易设置请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class IsolatedMarginModeRequest {
    
    /** 产品ID，如BTC-USDT */
    private String instId;
    
    /** 
     * 逐仓保证金模式
     * automatic：自动借币
     * autonomy：自主借币
     */
    private String isoMode;
}