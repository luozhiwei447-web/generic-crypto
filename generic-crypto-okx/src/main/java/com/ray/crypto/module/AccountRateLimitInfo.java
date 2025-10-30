package com.ray.crypto.module;

import lombok.Data;

/**
 * 账户限频信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AccountRateLimitInfo {
    /**
     * 限频类型
     */
    private String rateLimitType;
    
    /**
     * 当前已使用次数
     */
    private String countUsed;
    
    /**
     * 限频总次数
     */
    private String countLimit;
    
    /**
     * 重置时间戳
     */
    private String resetTime;
}