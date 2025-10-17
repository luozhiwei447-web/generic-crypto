package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取借币利息和限额请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class BorrowInterestLimitRequest {
    
    /** 
     * 产品类型
     * MARGIN：币币杠杆
     * VIP：尊享借币
     */
    private String type;
    
    /** 币种，如BTC，不填写表示查询所有币种 */
    private String ccy;
}