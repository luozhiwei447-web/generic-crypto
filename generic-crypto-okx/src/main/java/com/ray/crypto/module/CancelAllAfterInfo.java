package com.ray.crypto.module;

import lombok.Data;

/**
 * 倒计时全部撤单响应
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelAllAfterInfo {
    /**
     * 倒计时时间，单位为秒
     */
    private String timeOut;
    
    /**
     * 触发时间戳
     */
    private String triggerTime;
    
    /**
     * 系统完成订单请求处理的时间戳
     */
    private String ts;
}