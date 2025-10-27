package com.ray.crypto.module;

import lombok.Data;

/**
 * 市价全平仓响应
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class ClosePositionInfo {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 持仓方向
     */
    private String posSide;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 订单标签
     */
    private String tag;
    
    /**
     * 系统完成订单请求处理的时间戳
     */
    private String ts;
}