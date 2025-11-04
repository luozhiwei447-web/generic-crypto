package com.ray.crypto.module;

import lombok.Data;

/**
 * 撤销合约网格平仓订单响应信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class CancelClosePositionInfo {
    /**
     * 策略订单ID
     */
    private String algoId;
    
    /**
     * 平仓订单ID
     */
    private String ordId;
    
    /**
     * 事件执行结果的code，0代表成功
     */
    private String sCode;
    
    /**
     * 事件执行失败时的msg
     */
    private String sMsg;
}