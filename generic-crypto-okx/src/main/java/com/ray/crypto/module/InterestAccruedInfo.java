package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX计息记录信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class InterestAccruedInfo {
    
    /** 产品类型 */
    private String instType;
    
    /** 币种 */
    private String ccy;
    
    /** 产品ID */
    private String instId;
    
    /** 
     * 保证金模式
     * isolated：逐仓
     * cross：全仓
     */
    private String mgnMode;
    
    /** 计息金额 */
    private String interest;
    
    /** 计息时间，Unix时间戳的毫秒数格式 */
    private String interestTime;
    
    /** 日利率 */
    private String rate;
    
    /** 负债金额 */
    private String liab;
    
    /** 数据返回时间，Unix时间戳的毫秒数格式 */
    private String ts;
}