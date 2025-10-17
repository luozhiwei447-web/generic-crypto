package com.ray.crypto.module;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX获取计息记录请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class InterestAccruedRequest {
    
    /** 
     * 产品类型
     * MARGIN：币币杠杆
     * SWAP：永续合约
     * FUTURES：交割合约
     * OPTION：期权
     */
    private String instType;
    
    /** 币种，如BTC */
    private String ccy;
    
    /** 产品ID，如BTC-USDT */
    private String instId;
    
    /** 
     * 保证金模式
     * isolated：逐仓
     * cross：全仓
     */
    private String mgnMode;
    
    /** 请求此时间戳之后的分页内容，Unix时间戳的毫秒数格式 */
    private String after;
    
    /** 请求此时间戳之前的分页内容，Unix时间戳的毫秒数格式 */
    private String before;
    
    /** 返回结果的数量，最大为100，默认100条 */
    private String limit;
}