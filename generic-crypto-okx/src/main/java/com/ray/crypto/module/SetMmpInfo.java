package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX设置MMP响应实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetMmpInfo {
    
    /** 产品ID */
    private String instFamily;
    
    /** 时间窗口(毫秒) */
    private String timeInterval;
    
    /** 冻结时间(毫秒) */
    private String frozenInterval;
    
    /** 数量阈值 */
    private String qtyLimit;
}