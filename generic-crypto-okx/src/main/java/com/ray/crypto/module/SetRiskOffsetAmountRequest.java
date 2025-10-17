package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置风险对冲金额请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetRiskOffsetAmountRequest {
    
    /** 
     * 风险对冲类型
     * 1：现货对冲
     * 2：衍生品对冲
     */
    private String type;
    
    /** 风险对冲金额，单位为USD */
    private String amt;
}