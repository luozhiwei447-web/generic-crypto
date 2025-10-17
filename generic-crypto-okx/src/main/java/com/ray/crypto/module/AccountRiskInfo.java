package com.ray.crypto.module;

import lombok.Data;

import java.util.List;

/**
 * OKX账户和持仓风险信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class AccountRiskInfo {
    
    /** 账户总权益 */
    private String totalEq;
    
    /** 孤立保证金账户权益 */
    private String isoEq;
    
    /** 账户风险度 */
    private String adjEq;
    
    /** 美元层面有效保证金 */
    private String ordFroz;
    
    /** 美元层面账户维持保证金 */
    private String imr;
    
    /** 美元层面账户维持保证金率 */
    private String mmr;
    
    /** 美元层面保证金率 */
    private String mgnRatio;
    
    /** 美元层面账户层面占用的保证金 */
    private String notionalUsd;
    
    /** 美元层面账户层面全仓杠杆倍数 */
    private String uTime;
    
    /** 持仓信息 */
    private List<PositionRiskInfo> posData;
    
    /**
     * 持仓风险信息
     */
    @Data
    public static class PositionRiskInfo {
        
        /** 产品类型 */
        private String instType;
        
        /** 保证金模式 */
        private String mgnMode;
        
        /** 持仓ID */
        private String posId;
        
        /** 产品ID */
        private String instId;
        
        /** 持仓数量 */
        private String pos;
        
        /** 基础币种持仓数量 */
        private String baseBal;
        
        /** 计价币种持仓数量 */
        private String quoteBal;
        
        /** 持仓方向 */
        private String posSide;
        
        /** 美元价值 */
        private String notionalUsd;
        
        /** 持仓成本价 */
        private String avgPx;
        
        /** 标记价格 */
        private String markPx;
        
        /** 未实现收益 */
        private String upl;
        
        /** 未实现收益率 */
        private String uplRatio;
        
        /** 预估强平价 */
        private String liqPx;
        
        /** 保证金余额 */
        private String margin;
        
        /** 保证金率 */
        private String mgnRatio;
        
        /** 维持保证金 */
        private String mmr;
        
        /** 杠杆倍数 */
        private String lever;
        
        /** 负债额 */
        private String liab;
        
        /** 负债币种 */
        private String liabCcy;
        
        /** 利息 */
        private String interest;
        
        /** 持仓创建时间 */
        private String cTime;
        
        /** 持仓更新时间 */
        private String uTime;
    }
}