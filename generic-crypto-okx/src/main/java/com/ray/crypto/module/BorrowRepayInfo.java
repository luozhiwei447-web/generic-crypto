package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX手动借币还币信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class BorrowRepayInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 
     * 借币还币方向
     * borrow：借币
     * repay：还币
     */
    private String side;
    
    /** 借币还币数量 */
    private String amt;
    
    /** 借币还币后余额 */
    private String bal;
}