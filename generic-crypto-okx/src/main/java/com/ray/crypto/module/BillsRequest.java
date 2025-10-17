package com.ray.crypto.module;

import com.ray.crypto.constants.InstrumentType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX账单流水请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class BillsRequest {
    
    /** 产品类型 */
    private InstrumentType instType;
    
    /** 币种 */
    private String ccy;
    
    /** 保证金模式 */
    private String mgnMode;
    
    /** 合约类型 */
    private String ctType;
    
    /** 账单类型 */
    private String type;
    
    /** 账单子类型 */
    private String subType;
    
    /** 请求此时间戳之后的分页内容 */
    private String after;
    
    /** 请求此时间戳之前的分页内容 */
    private String before;
    
    /** 返回结果的数量，最大为100，默认100条 */
    private String limit;
}