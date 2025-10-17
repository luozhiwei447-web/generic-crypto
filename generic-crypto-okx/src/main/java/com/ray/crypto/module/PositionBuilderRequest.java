package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX持仓构建器请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class PositionBuilderRequest {
    
    /** 产品ID，如BTC-USD-SWAP */
    private String instId;
    
    /** 
     * 持仓方向
     * long：多头
     * short：空头
     * net：净持仓
     */
    private String posSide;
    
    /** 持仓数量 */
    private String sz;
    
    /** 委托价格 */
    private String px;
}