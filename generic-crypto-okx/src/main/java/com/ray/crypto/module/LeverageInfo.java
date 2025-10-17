package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX杠杆倍数信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class LeverageInfo {
    
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
    
    /** 
     * 持仓方向
     * long：多头
     * short：空头
     * net：净持仓
     */
    private String posSide;
}