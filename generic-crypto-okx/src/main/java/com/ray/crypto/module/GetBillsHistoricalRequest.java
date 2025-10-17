package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取历史账单流水请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class GetBillsHistoricalRequest {
    
    /** 申请ID */
    private String applyId;
}