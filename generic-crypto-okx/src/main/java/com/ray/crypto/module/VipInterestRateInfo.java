package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX尊享借币还币历史信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class VipInterestRateInfo {
    
    /** 币种 */
    private String ccy;
    
    /** 借币还币方向 */
    private String side;
    
    /** 借币还币数量 */
    private String amt;
    
    /** 利率 */
    private String rate;
    
    /** 时间戳 */
    private String ts;
}