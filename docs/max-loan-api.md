# 获取产品最大可借API使用说明

## 接口描述

获取产品最大可借接口用于查询指定产品在当前账户状态下的最大可借数量。

## 接口信息

- **接口路径**: `/api/v5/account/max-loan`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `instId`: 产品ID（必填），如BTC-USDT
- `mgnMode`: 保证金模式（必填）
  - `isolated`: 逐仓模式
  - `cross`: 全仓模式
- `mgnCcy`: 保证金币种（必填）

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询BTC-USDT逐仓模式最大可借
public void getMaxLoanIsolated() {
    MaxLoanRequest request = new MaxLoanRequest()
        .setInstId("BTC-USDT")
        .setMgnMode(MarginMode.ISOLATED.getValue())
        .setMgnCcy("USDT");
    
    List<MaxLoanInfo> result = tradingAccountApi.getMaxLoan(request);
    // 处理返回结果
}

// 查询BTC-USDT全仓模式最大可借
public void getMaxLoanCross() {
    MaxLoanRequest request = new MaxLoanRequest()
        .setInstId("BTC-USDT")
        .setMgnMode(MarginMode.CROSS.getValue())
        .setMgnCcy("USDT");
    
    List<MaxLoanInfo> result = tradingAccountApi.getMaxLoan(request);
    // 处理返回结果
}

// 查询ETH-USDT逐仓模式最大可借
public void getEthMaxLoan() {
    MaxLoanRequest request = new MaxLoanRequest()
        .setInstId("ETH-USDT")
        .setMgnMode(MarginMode.ISOLATED.getValue())
        .setMgnCcy("USDT");
    
    List<MaxLoanInfo> result = tradingAccountApi.getMaxLoan(request);
    // 处理返回结果
}

// 查询BTC保证金币种的最大可借
public void getBtcMaxLoan() {
    MaxLoanRequest request = new MaxLoanRequest()
        .setInstId("BTC-USDT")
        .setMgnMode(MarginMode.CROSS.getValue())
        .setMgnCcy("BTC");
    
    List<MaxLoanInfo> result = tradingAccountApi.getMaxLoan(request);
    // 处理返回结果
}
```

## 返回字段说明

- `instId`: 产品ID
- `mgnMode`: 保证金模式
- `mgnCcy`: 保证金币种
- `maxLoan`: 最大可借数量
- `ccy`: 币种
- `side`: 持仓方向（仅适用于逐仓模式）

## 注意事项

1. 最大可借数量会根据账户余额、持仓情况、风险度等因素动态变化
2. 逐仓模式下会返回多空两个方向的可借信息
3. 全仓模式下通常只返回一个可借信息
4. 可借数量受到平台风控限制和个人信用额度限制
5. 实际借币时可能因为市场流动性等因素无法借到最大数量

## 应用场景

- 杠杆交易前确认可借额度
- 风险管理和仓位规划
- 自动化交易策略中的资金管理
- 账户流动性评估