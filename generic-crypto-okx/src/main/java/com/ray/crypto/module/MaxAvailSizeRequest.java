package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX查询最大可用余额请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class MaxAvailSizeRequest {
    
    /** 产品ID，如BTC-USDT */
    private String instId;
    
    /** 
     * 交易模式
     * cash：现金
     * isolated：逐仓
     * cross：全仓
     */
    private String tdMode;
    
    /** 保证金币种，仅适用于单币种保证金模式下的全仓杂交易 */
    private String ccy;
    
    /** 是否仅减仓，true或false，默认false */
    private Boolean reduceOnly;
    
    /** 是否不自动借币，true或false，默认false */
    private Boolean unSpotOffset;
    
    /** 是否使用快速保证金模式，true或false，默认false */
    private Boolean quickMgnType;
}