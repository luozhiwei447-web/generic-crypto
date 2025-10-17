package com.ray.crypto.module;

import com.ray.crypto.constants.InstrumentType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OKX账户和持仓风险请求实体
 * 
 * @author ray
 * @date 2024-01-01
 */
@Data
@Accessors(chain = true)
public class AccountRiskRequest {
    
    /** 产品类型 */
    private InstrumentType instType;
}