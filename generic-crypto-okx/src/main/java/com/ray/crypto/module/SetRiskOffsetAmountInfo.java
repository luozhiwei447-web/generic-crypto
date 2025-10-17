package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置风险对冲金额响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetRiskOffsetAmountInfo {
    
    /** 
     * 风险对冲类型
     * 1：现货对冲
     * 2：衍生品对冲
     */
    private String type;
    
    /** 风险对冲金额，单位为USD */
    private String amt;
}