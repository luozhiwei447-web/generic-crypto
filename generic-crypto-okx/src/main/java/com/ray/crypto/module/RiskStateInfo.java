package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX账户风险状态信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class RiskStateInfo {
    
    /** 
     * 账户风险状态
     * true：风险状态
     * false：正常状态
     */
    private String atRisk;
    
    /** 衡生品账户风险状态时间，Unix时间戳的毫秒数格式 */
    private String atRiskIdx;
    
    /** 保证金账户风险状态时间，Unix时间戳的毫秒数格式 */
    private String atRiskMgn;
    
    /** 数据返回时间，Unix时间戳的毫秒数格式 */
    private String ts;
}