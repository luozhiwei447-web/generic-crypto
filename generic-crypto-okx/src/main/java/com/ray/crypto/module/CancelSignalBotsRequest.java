package com.ray.crypto.module;

import lombok.Data;
import java.util.List;

/**
 * 撤销信号机器人请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelSignalBotsRequest {
    /**
     * 策略订单ID列表
     */
    private List<AlgoIdItem> algoIds;
    
    @Data
    public static class AlgoIdItem {
        /**
         * 策略订单ID
         */
        private String algoId;
    }
}