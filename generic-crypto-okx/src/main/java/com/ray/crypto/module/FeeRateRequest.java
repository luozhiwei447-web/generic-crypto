package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取交易手续费费率请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class FeeRateRequest {
    
    /** 
     * 产品类型
     * SPOT：币币
     * MARGIN：币币杠杆
     * SWAP：永续合约
     * FUTURES：交割合约
     * OPTION：期权
     */
    private String instType;
    
    /** 产品ID，如BTC-USDT */
    private String instId;
    
    /** 标的指数，如BTC-USD，仅适用于交割/永续/期权 */
    private String uly;
    
    /** 交易品种，如BTC-USD，仅适用于交割/永续/期权 */
    private String instFamily;
}