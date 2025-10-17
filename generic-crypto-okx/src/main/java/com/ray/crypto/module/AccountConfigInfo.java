package com.ray.crypto.module;

import lombok.Data;

/**
 * OKX账户配置信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AccountConfigInfo {
    
    /** 账户层面是否开启自动借币 */
    private String autoLoan;
    
    /** 账户层面保证金模式 */
    private String acctLv;
    
    /** 持仓模式 */
    private String posMode;
    
    /** 是否开启现货对冲 */
    private String spotOffsetType;
    
    /** 账户ID */
    private String uid;
    
    /** 主账户用户名 */
    private String mainUid;
    
    /** 账户标签 */
    private String label;
    
    /** 账户角色 */
    private String roleType;
    
    /** 交易手续费费率等级 */
    private String traderInsts;
    
    /** 账户层面是否开启组合保证金 */
    private String opAuth;
    
    /** 账户层面是否开启期权交易 */
    private String kycLv;
    
    /** 账户层面是否开启现货杠杆交易 */
    private String ip;
    
    /** 账户层面是否开启统一账户 */
    private String perm;
}