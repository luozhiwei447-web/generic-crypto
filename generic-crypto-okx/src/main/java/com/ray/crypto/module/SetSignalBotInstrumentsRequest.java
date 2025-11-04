package com.ray.crypto.module;

import lombok.Data;
import java.util.List;

/**
 * 设置信号机器人产品请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class SetSignalBotInstrumentsRequest {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 产品ID列表
     */
    private List<String> instIds;
}