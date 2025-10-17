# 获取杠杆预估信息API使用说明

## 接口描述

获取杠杆预估信息接口用于在调整杠杆倍数前，预估调整后的最大可买卖数量等信息。

## 接口信息

- **接口路径**: `/api/v5/account/adjust-leverage-info`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `instType`: 产品类型（必填）
  - `SWAP`: 永续合约
  - `FUTURES`: 交割合约
  - `MARGIN`: 杠杆交易
- `mgnMode`: 保证金模式（必填）
  - `isolated`: 逐仓模式
  - `cross`: 全仓模式
- `lever`: 杠杆倍数（必填）
- `instId`: 产品ID（可选），如BTC-USD-SWAP
- `ccy`: 保证金币种（可选），仅适用于跨币种保证金模式下的全仓合约

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 预估BTC永续合约10倍杠杆逐仓模式信息
public void getLeverageEstimatedSwap() {
    LeverageEstimatedRequest request = new LeverageEstimatedRequest()
        .setInstType(InstrumentType.SWAP.name())
        .setMgnMode(MarginMode.ISOLATED.getValue())
        .setLever("10")
        .setInstId("BTC-USD-SWAP");
    
    List<LeverageEstimatedInfo> result = tradingAccountApi.getLeverageEstimated(request);
    // 处理返回结果
}

// 预估所有永续合约20倍杠杆全仓模式信息
public void getLeverageEstimatedAllSwap() {
    LeverageEstimatedRequest request = new LeverageEstimatedRequest()
        .setInstType(InstrumentType.SWAP.name())
        .setMgnMode(MarginMode.CROSS.getValue())
        .setLever("20");
    
    List<LeverageEstimatedInfo> result = tradingAccountApi.getLeverageEstimated(request);
    // 处理返回结果
}

// 预估杠杆交易5倍杠杆信息
public void getLeverageEstimatedMargin() {
    LeverageEstimatedRequest request = new LeverageEstimatedRequest()
        .setInstType(InstrumentType.MARGIN.name())
        .setMgnMode(MarginMode.CROSS.getValue())
        .setLever("5")
        .setInstId("BTC-USDT");
    
    List<LeverageEstimatedInfo> result = tradingAccountApi.getLeverageEstimated(request);
    // 处理返回结果
}

// 预估跨币种保证金模式杠杆信息
public void getLeverageEstimatedWithCcy() {
    LeverageEstimatedRequest request = new LeverageEstimatedRequest()
        .setInstType(InstrumentType.SWAP.name())
        .setMgnMode(MarginMode.CROSS.getValue())
        .setLever("15")
        .setInstId("BTC-USD-SWAP")
        .setCcy("USDT");
    
    List<LeverageEstimatedInfo> result = tradingAccountApi.getLeverageEstimated(request);
    // 处理返回结果
}
```

## 返回字段说明

- `instId`: 产品ID
- `lever`: 杠杆倍数
- `mgnMode`: 保证金模式
- `ccy`: 保证金币种
- `posSide`: 持仓方向
- `maxBuy`: 最大可买数量
- `maxSell`: 最大可卖数量

## 注意事项

1. 该接口用于预估，不会实际修改杠杆倍数设置
2. 可以查询单个产品或所有产品的预估信息
3. 预估结果基于当前账户状态和市场条件
4. 不同产品类型支持的杠杆倍数范围不同
5. 跨币种保证金模式下需要指定保证金币种

## 应用场景

- 调整杠杆倍数前的风险评估
- 计算调整杠杆后的最大交易量
- 优化杠杆配置策略
- 风险管理和仓位规划