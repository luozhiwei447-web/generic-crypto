package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX设置MMP请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class SetMmpRequest {
    
    /** 产品ID */
    private String instFamily;
    
    /** 时间窗口(毫秒) */
    private String timeInterval;
    
    /** 冻结时间(毫秒) */
    private String frozenInterval;
    
    /** 数量阈值 */
    private String qtyLimit;
}