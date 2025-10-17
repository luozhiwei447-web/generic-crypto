package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX手动借币还币请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class BorrowRepayRequest {
    
    /** 币种，如BTC */
    private String ccy;
    
    /** 
     * 借币还币方向
     * borrow：借币
     * repay：还币
     */
    private String side;
    
    /** 借币还币数量 */
    private String amt;
}