package com.ray.crypto.module;

import lombok.Data;

/**
 * 成交明细信息
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class FillsInfo {
    /**
     * 产品类型
     */
    private String instType;
    
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 成交ID
     */
    private String tradeId;
    
    /**
     * 订单ID
     */
    private String ordId;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 成交价格
     */
    private String fillPx;
    
    /**
     * 成交数量
     */
    private String fillSz;
    
    /**
     * 订单方向
     */
    private String side;
    
    /**
     * 持仓方向
     */
    private String posSide;
    
    /**
     * 执行类型
     */
    private String execType;
    
    /**
     * 手续费数量
     */
    private String fee;
    
    /**
     * 手续费币种
     */
    private String feeCcy;
    
    /**
     * 成交时间
     */
    private String ts;
    
    /**
     * 订单标签
     */
    private String tag;
    
    /**
     * 流动性方向
     */
    private String fillTime;
    
    /**
     * 成交序号
     */
    private String fillIdxPx;
    
    /**
     * 成交时间戳
     */
    private String billId;
}