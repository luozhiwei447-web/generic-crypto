package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX杠杆预估信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class LeverageEstimatedInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 杠杆倍数 */
    private String lever;
    
    /** 
     * 保证金模式
     * isolated：逐仓
     * cross：全仓
     */
    private String mgnMode;
    
    /** 保证金币种 */
    private String ccy;
    
    /** 
     * 持仓方向
     * long：多头
     * short：空头
     * net：净持仓
     */
    private String posSide;
    
    /** 最大可买数量 */
    private String maxBuy;
    
    /** 最大可卖数量 */
    private String maxSell;
}