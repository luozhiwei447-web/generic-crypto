package com.ray.crypto.module;

import lombok.Data;

/**
 * 获取信号请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SignalsRequest {
    /**
     * 信号源类型
     */
    private String signalSourceType;
    
    /**
     * 请求数据的时间范围，单位为毫秒
     */
    private String after;
    
    /**
     * 请求数据的时间范围，单位为毫秒
     */
    private String before;
    
    /**
     * 返回结果的数量，最大为100，默认返回100条
     */
    private String limit;
}