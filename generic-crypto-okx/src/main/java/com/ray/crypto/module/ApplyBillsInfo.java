package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX申请账单流水响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ApplyBillsInfo {
    
    /** 申请ID */
    private String applyId;
    
    /** 申请状态 */
    private String state;
    
    /** 申请时间 */
    private String ts;
}