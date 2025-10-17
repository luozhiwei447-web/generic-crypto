# 增加/减少保证金API使用说明

## 接口描述

增加/减少保证金接口用于调整逐仓模式下指定持仓的保证金数量，帮助管理持仓风险。

## 接口信息

- **接口路径**: `/api/v5/account/position/margin-balance`
- **请求方法**: POST
- **权限要求**: 需要交易权限

## 参数说明

- `instId`: 产品ID（必填），如BTC-USD-SWAP
- `posSide`: 持仓方向（必填）
  - `long`: 多头
  - `short`: 空头
  - `net`: 净持仓（单向持仓模式下）
- `type`: 调整保证金类型（必填）
  - `add`: 增加保证金
  - `reduce`: 减少保证金
- `amt`: 调整保证金数量（必填）
- `ccy`: 保证金币种（可选），仅适用于跨币种保证金模式下的全仓合约
- `auto`: 是否自动借币（可选），默认false

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 增加BTC永续合约多头持仓保证金
public void addMargin() {
    MarginBalanceRequest request = new MarginBalanceRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.LONG.getValue())
        .setType(MarginAdjustType.ADD.getValue())
        .setAmt("100");
    
    List<MarginBalanceInfo> result = tradingAccountApi.marginBalance(request);
    // 处理返回结果
}

// 减少BTC永续合约空头持仓保证金
public void reduceMargin() {
    MarginBalanceRequest request = new MarginBalanceRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.SHORT.getValue())
        .setType(MarginAdjustType.REDUCE.getValue())
        .setAmt("50");
    
    List<MarginBalanceInfo> result = tradingAccountApi.marginBalance(request);
    // 处理返回结果
}

// 增加保证金（跨币种保证金模式）
public void addMarginWithCcy() {
    MarginBalanceRequest request = new MarginBalanceRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.LONG.getValue())
        .setType(MarginAdjustType.ADD.getValue())
        .setAmt("1000")
        .setCcy("USDT");
    
    List<MarginBalanceInfo> result = tradingAccountApi.marginBalance(request);
    // 处理返回结果
}

// 增加保证金（自动借币）
public void addMarginWithAuto() {
    MarginBalanceRequest request = new MarginBalanceRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.NET.getValue())
        .setType(MarginAdjustType.ADD.getValue())
        .setAmt("200")
        .setAuto(true);
    
    List<MarginBalanceInfo> result = tradingAccountApi.marginBalance(request);
    // 处理返回结果
}
```

## 返回字段说明

- `instId`: 产品ID
- `posSide`: 持仓方向
- `amt`: 调整保证金数量
- `type`: 调整保证金类型

## 注意事项

1. 该接口仅适用于逐仓模式下的合约持仓
2. 增加保证金需要确保账户有足够的可用余额
3. 减少保证金不能导致持仓保证金率低于维持保证金率
4. 自动借币功能可以在余额不足时自动借入所需资金
5. 跨币种保证金模式下需要指定保证金币种
6. 调整保证金会影响持仓的强平价格和风险度