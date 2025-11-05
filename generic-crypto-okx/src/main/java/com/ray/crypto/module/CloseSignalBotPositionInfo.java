package com.ray.crypto.module;

import lombok.Data;

/**
 * 信号机器人平仓响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CloseSignalBotPositionInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 事件执行结果的code，0代表成功
     */
    private String sCode;
    
    /**
     * 事件执行失败时的msg
     */
    private String sMsg;
}