package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取杠杆预估信息请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class LeverageEstimatedRequest {
    
    /** 产品类型，SWAP：永续合约，FUTURES：交割合约，MARGIN：杠杆交易 */
    private String instType;
    
    /** 
     * 保证金模式
     * isolated：逐仓
     * cross：全仓
     */
    private String mgnMode;
    
    /** 杠杆倍数 */
    private String lever;
    
    /** 产品ID，如BTC-USD-SWAP */
    private String instId;
    
    /** 保证金币种，仅适用于跨币种保证金模式下的全仓合约 */
    private String ccy;
}