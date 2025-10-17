# 设置手续费抵扣类型API使用说明

## 接口描述

设置手续费抵扣类型接口用于配置交易手续费的抵扣方式，支持USDT抵扣、OKB抵扣和币种抵扣三种模式。

## 接口信息

- **接口路径**: `/api/v5/account/set-fee-type`
- **请求方法**: POST
- **权限要求**: 需要交易权限

## 参数说明

- `feeType`: 手续费抵扣类型（必填）
  - `0`: USDT抵扣
  - `1`: OKB抵扣
  - `2`: 币种抵扣

## 抵扣类型说明

### USDT抵扣 (feeType = "0")
- 使用USDT支付手续费
- 适用于持有大量USDT的用户
- 手续费计算简单直观

### OKB抵扣 (feeType = "1")
- 使用OKB代币支付手续费
- 通常享有手续费折扣优惠
- 需要账户持有足够的OKB余额

### 币种抵扣 (feeType = "2")
- 使用交易币种本身支付手续费
- 例如：BTC-USDT交易时，买入用USDT支付手续费，卖出用BTC支付手续费
- 无需额外持有其他币种作为手续费

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 设置为USDT抵扣
public void setUsdtFeeType() {
    SetFeeTypeRequest request = new SetFeeTypeRequest()
        .setFeeType(FeeType.USDT.getValue());
    
    List<SetFeeTypeInfo> result = tradingAccountApi.setFeeType(request);
    // 处理返回结果
}

// 设置为OKB抵扣
public void setOkbFeeType() {
    SetFeeTypeRequest request = new SetFeeTypeRequest()
        .setFeeType(FeeType.OKB.getValue());
    
    List<SetFeeTypeInfo> result = tradingAccountApi.setFeeType(request);
    // 处理返回结果
}

// 设置为币种抵扣
public void setCurrencyFeeType() {
    SetFeeTypeRequest request = new SetFeeTypeRequest()
        .setFeeType(FeeType.CURRENCY.getValue());
    
    List<SetFeeTypeInfo> result = tradingAccountApi.setFeeType(request);
    // 处理返回结果
}
```

## 返回字段说明

- `feeType`: 设置后的手续费抵扣类型

## 注意事项

1. 设置生效后，后续交易将按照新的抵扣类型收取手续费
2. OKB抵扣通常享有折扣优惠，具体折扣率请参考平台规则
3. 使用OKB或USDT抵扣时，需确保账户有足够余额
4. 币种抵扣模式下，手续费直接从交易币种中扣除
5. 设置变更可能需要一定时间生效

## 应用场景

- 优化交易成本
- 根据持仓情况选择最优抵扣方式
- 享受OKB持有者的手续费折扣
- 简化资金管理（币种抵扣模式）

## 相关接口

- [获取费率API](fee-rate-api.md) - 查看当前费率
- [获取账户配置API](account-config-api.md) - 查看当前手续费抵扣设置