package com.ray.crypto.module;

import lombok.Data;

/**
 * 大宗撤单响应
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class MassCancelOrderInfo {
    /**
     * 产品类型
     */
    private String instType;
    
    /**
     * 交易品种
     */
    private String instFamily;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 系统完成订单请求处理的时间戳
     */
    private String ts;
}