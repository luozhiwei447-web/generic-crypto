package com.ray.crypto.module;

import lombok.Data;

import java.util.List;

/**
 * OKX交易产品信息实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class InstrumentInfo {
    
    /** 产品类型 */
    private String instType;
    
    /** 产品ID */
    private String instId;
    
    /** 标的指数 */
    private String uly;
    
    /** 交易品种 */
    private String instFamily;
    
    /** 交易货币币种 */
    private String baseCcy;
    
    /** 计价货币币种 */
    private String quoteCcy;
    
    /** 盈亏结算和保证金币种 */
    private String settleCcy;
    
    /** 合约面值 */
    private String ctVal;
    
    /** 合约乘数 */
    private String ctMult;
    
    /** 合约面值计价币种 */
    private String ctValCcy;
    
    /** 期权类型，C或P */
    private String optType;
    
    /** 行权价格 */
    private String stk;
    
    /** 上线时间 */
    private String listTime;
    
    /** 集合竞价结束时间 */
    private String auctionEndTime;
    
    /** 连续交易开始时间 */
    private String contTdSwTime;
    
    /** 盘前永续合约转为普通永续合约的时间 */
    private String preMktSwTime;
    
    /** 开盘类型 */
    private String openType;
    
    /** 产品下线时间 */
    private String expTime;
    
    /** 最大杠杆倍数 */
    private String lever;
    
    /** 下单价格精度 */
    private String tickSz;
    
    /** 下单数量精度 */
    private String lotSz;
    
    /** 最小下单数量 */
    private String minSz;
    
    /** 合约类型 */
    private String ctType;
    
    /** 产品状态 */
    private String state;
    
    /** 交易规则类型 */
    private String ruleType;
    
    /** 限价单的单笔最大委托数量 */
    private String maxLmtSz;
    
    /** 市价单的单笔最大委托数量 */
    private String maxMktSz;
    
    /** 限价单的单笔最大美元价值 */
    private String maxLmtAmt;
    
    /** 市价单的单笔最大美元价值 */
    private String maxMktAmt;
    
    /** 时间加权单的单笔最大委托数量 */
    private String maxTwapSz;
    
    /** 冰山委托的单笔最大委托数量 */
    private String maxIcebergSz;
    
    /** 计划委托的单笔最大委托数量 */
    private String maxTriggerSz;
    
    /** 止盈止损市价委托的单笔最大委托数量 */
    private String maxStopSz;
    
    /** 交割合约是否支持每日结算 */
    private Boolean futureSettlement;
    
    /** 可用于交易的计价币种列表 */
    private List<String> tradeQuoteCcyList;
    
    /** 产品唯一标识代码 */
    private Integer instIdCode;
}