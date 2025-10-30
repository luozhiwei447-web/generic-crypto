package com.ray.crypto.module;

import lombok.Data;

/**
 * 订单预检查响应
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OrderPrecheckInfo {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 交易模式
     */
    private String tdMode;
    
    /**
     * 订单方向
     */
    private String side;
    
    /**
     * 订单类型
     */
    private String ordType;
    
    /**
     * 委托数量
     */
    private String sz;
    
    /**
     * 委托价格
     */
    private String px;
    
    /**
     * 预检查结果代码
     */
    private String sCode;
    
    /**
     * 预检查结果信息
     */
    private String sMsg;
    
    /**
     * 系统完成订单请求处理的时间戳
     */
    private String ts;
}