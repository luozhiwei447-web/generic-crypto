package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX逐仓交易设置信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class IsolatedMarginModeInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 
     * 逐仓保证金模式
     * automatic：自动借币
     * autonomy：自主借币
     */
    private String isoMode;
}