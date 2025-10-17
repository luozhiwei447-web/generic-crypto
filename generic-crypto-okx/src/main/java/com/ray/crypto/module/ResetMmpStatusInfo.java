package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX重置MMP状态响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ResetMmpStatusInfo {
    
    /** 产品ID */
    private String instFamily;
    
    /** 重置结果 */
    private String result;
}