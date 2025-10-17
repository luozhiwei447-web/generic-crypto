package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置杠杆倍数请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class LeverageRequest {
    
    /** 产品ID，如BTC-USD-SWAP */
    private String instId;
    
    /** 保证金币种，仅适用于跨币种保证金模式的全仓杠杆订单 */
    private String ccy;
    
    /** 杠杆倍数 */
    private String lever;
    
    /** 
     * 保证金模式
     * isolated：逐仓
     * cross：全仓
     */
    private String mgnMode;
    
    /** 
     * 持仓方向
     * long：多头
     * short：空头
     * net：净持仓（单向持仓模式下）
     */
    private String posSide;
}