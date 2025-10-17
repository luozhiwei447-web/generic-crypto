package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX查询最大可买卖/开仓数量请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class MaxSizeRequest {
    
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
    
    /** 委托价格，仅适用于币币交易 */
    private String px;
    
    /** 杠杆倍数，仅适用于合约交易 */
    private String leverage;
    
    /** 是否不自动借币，true或false，默认false */
    private Boolean unSpotOffset;
}