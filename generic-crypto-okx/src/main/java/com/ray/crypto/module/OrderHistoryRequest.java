package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取订单历史请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OrderHistoryRequest {
    /**
     * 产品类型
     */
    private String instType;
    
    /**
     * 标的指数
     */
    private String uly;
    
    /**
     * 交易品种
     */
    private String instFamily;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 订单类型
     */
    private String ordType;
    
    /**
     * 订单状态
     */
    private String state;
    
    /**
     * 订单种类
     */
    private String category;
    
    /**
     * 请求此时间戳之前的分页内容
     */
    private String after;
    
    /**
     * 请求此时间戳之后的分页内容
     */
    private String before;
    
    /**
     * 开始时间
     */
    private String begin;
    
    /**
     * 结束时间
     */
    private String end;
    
    /**
     * 返回结果的数量
     */
    private String limit;
}