# 获取费率API使用说明

## 接口描述

获取费率接口用于查询指定产品的交易手续费费率信息，包括挂单费率和吃单费率。

## 接口信息

- **接口路径**: `/api/v5/account/trade-fee`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `instType`: 产品类型（必填）
  - `SPOT`: 币币交易
  - `MARGIN`: 币币杠杆
  - `SWAP`: 永续合约
  - `FUTURES`: 交割合约
  - `OPTION`: 期权
- `instId`: 产品ID（可选），如BTC-USDT
- `uly`: 标的指数（可选），如BTC-USD，仅适用于交割/永续/期权
- `instFamily`: 交易品种（可选），如BTC-USD，仅适用于交割/永续/期权

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询BTC-USDT现货费率
public void getSpotFeeRate() {
    FeeRateRequest request = new FeeRateRequest()
        .setInstType(InstrumentType.SPOT.name())
        .setInstId("BTC-USDT");
    
    List<FeeRateInfo> result = tradingAccountApi.getTradeFee(request);
    // 处理返回结果
}

// 查询BTC永续合约费率
public void getSwapFeeRate() {
    FeeRateRequest request = new FeeRateRequest()
        .setInstType(InstrumentType.SWAP.name())
        .setInstId("BTC-USD-SWAP");
    
    List<FeeRateInfo> result = tradingAccountApi.getTradeFee(request);
    // 处理返回结果
}

// 查询所有永续合约费率
public void getAllSwapFeeRates() {
    FeeRateRequest request = new FeeRateRequest()
        .setInstType(InstrumentType.SWAP.name());
    
    List<FeeRateInfo> result = tradingAccountApi.getTradeFee(request);
    // 处理返回结果
}

// 查询BTC标的所有合约费率
public void getBtcContractFeeRates() {
    FeeRateRequest request = new FeeRateRequest()
        .setInstType(InstrumentType.FUTURES.name())
        .setUly("BTC-USD");
    
    List<FeeRateInfo> result = tradingAccountApi.getTradeFee(request);
    // 处理返回结果
}

// 查询BTC交易品种费率
public void getBtcInstFamilyFeeRates() {
    FeeRateRequest request = new FeeRateRequest()
        .setInstType(InstrumentType.OPTION.name())
        .setInstFamily("BTC-USD");
    
    List<FeeRateInfo> result = tradingAccountApi.getTradeFee(request);
    // 处理返回结果
}
```

## 返回字段说明

- `instType`: 产品类型
- `instId`: 产品ID
- `makerU`: 挂单手续费费率（U本位结算）
- `takerU`: 吃单手续费费率（U本位结算）
- `makerUSDC`: 挂单手续费费率（USDC结算）
- `takerUSDC`: 吃单手续费费率（USDC结算）
- `delivery`: 交割手续费费率
- `exercise`: 行权手续费费率
- `category`: 产品分类
- `ts`: 数据返回时间，Unix时间戳的毫秒数格式

## 注意事项

1. 费率可能根据用户的VIP等级有所不同
2. 不同产品类型的费率结构可能不同
3. 合约产品还包括交割费率等特殊费率
4. 期权产品包括行权费率
5. 费率信息会实时更新，建议定期查询最新费率

## 应用场景

- 交易成本计算
- 策略收益评估
- 费率比较和优化
- 风险管理中的成本控制
- 自动化交易中的费率监控