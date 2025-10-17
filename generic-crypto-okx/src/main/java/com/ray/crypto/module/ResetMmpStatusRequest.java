package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX重置MMP状态请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class ResetMmpStatusRequest {
    
    /** 产品ID */
    private String instFamily;
}