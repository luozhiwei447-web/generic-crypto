package com.ray.crypto.module;

import lombok.Data;

/**
 * 下单请求
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
public class PlaceOrderRequest {
    /**
     * 产品ID
     */
    private String instId;
    
    /**
     * 交易模式
     */
    private String tdMode;
    
    /**
     * 订单方向
     */
    private String side;
    
    /**
     * 订单类型
     */
    private String ordType;
    
    /**
     * 委托数量
     */
    private String sz;
    
    /**
     * 委托价格
     */
    private String px;
    
    /**
     * 持仓方向
     */
    private String posSide;
    
    /**
     * 是否只减仓
     */
    private Boolean reduceOnly;
    
    /**
     * 客户自定义订单ID
     */
    private String clOrdId;
    
    /**
     * 订单标签
     */
    private String tag;
    
    /**
     * 是否禁止币币交易
     */
    private Boolean banAmend;
    
    /**
     * 自成交保护
     */
    private String stpId;
    
    /**
     * 自成交保护模式
     */
    private String stpMode;
    
    /**
     * 保证金币种
     */
    private String ccy;
    
    /**
     * 执行类型
     */
    private String execType;
    
    /**
     * 快速保证金模式
     */
    private String quickMgnType;
    
    /**
     * 一键借币类型
     */
    private String tgtCcy;
    
    /**
     * 附加订单数据
     */
    private String attachAlgoOrds;
}