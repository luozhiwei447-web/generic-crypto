package com.ray.crypto.module;

import lombok.Data;
import java.util.List;

/**
 * 撤销信号机器人子订单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelSignalBotSubOrderRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 订单ID列表
     */
    private List<String> ordIds;
}