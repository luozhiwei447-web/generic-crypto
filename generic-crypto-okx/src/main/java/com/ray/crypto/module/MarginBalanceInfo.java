package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX调整保证金响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MarginBalanceInfo {
    
    /** 产品ID */
    private String instId;
    
    /** 
     * 持仓方向
     * long：多头
     * short：空头
     * net：净持仓
     */
    private String posSide;
    
    /** 调整保证金数量 */
    private String amt;
    
    /** 
     * 调整保证金类型
     * add：增加
     * reduce：减少
     */
    private String type;
}