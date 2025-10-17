package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX调整保证金请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class MarginBalanceRequest {
    
    /** 产品ID，如BTC-USD-SWAP */
    private String instId;
    
    /** 
     * 持仓方向
     * long：多头
     * short：空头
     * net：净持仓（单向持仓模式下）
     */
    private String posSide;
    
    /** 
     * 调整保证金类型
     * add：增加
     * reduce：减少
     */
    private String type;
    
    /** 调整保证金数量 */
    private String amt;
    
    /** 保证金币种，仅适用于跨币种保证金模式下的全仓合约 */
    private String ccy;
    
    /** 是否自动借币，true或false，默认false */
    private Boolean auto;
}