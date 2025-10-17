package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取杠杆倍数请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class GetLeverageRequest {
    
    /** 产品ID，如BTC-USD-SWAP */
    private String instId;
    
    /** 
     * 保证金模式
     * isolated：逐仓
     * cross：全仓
     */
    private String mgnMode;
}