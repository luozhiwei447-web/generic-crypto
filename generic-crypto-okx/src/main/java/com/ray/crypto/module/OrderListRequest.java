package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取订单列表请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class OrderListRequest {
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
     * 请求此ID之前（更旧的数据）的分页内容
     */
    private String after;
    
    /**
     * 请求此ID之后（更新的数据）的分页内容
     */
    private String before;
    
    /**
     * 返回结果的数量
     */
    private String limit;
}