# 获取利率API使用说明

## 接口描述

获取利率接口用于查询用户当前的杠杆借币利率，帮助用户了解借币成本。

## 接口信息

- **接口路径**: `/api/v5/account/interest-rate`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `ccy`: 币种（可选），如BTC，不填写表示查询所有币种

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询所有币种的利率
public void getAllInterestRates() {
    InterestRateRequest request = new InterestRateRequest();
    
    List<InterestRateInfo> result = tradingAccountApi.getInterestRate(request);
    // 处理返回结果
}

// 查询BTC的利率
public void getBtcInterestRate() {
    InterestRateRequest request = new InterestRateRequest()
        .setCcy("BTC");
    
    List<InterestRateInfo> result = tradingAccountApi.getInterestRate(request);
    // 处理返回结果
}

// 查询USDT的利率
public void getUsdtInterestRate() {
    InterestRateRequest request = new InterestRateRequest()
        .setCcy("USDT");
    
    List<InterestRateInfo> result = tradingAccountApi.getInterestRate(request);
    // 处理返回结果
}

// 查询ETH的利率
public void getEthInterestRate() {
    InterestRateRequest request = new InterestRateRequest()
        .setCcy("ETH");
    
    List<InterestRateInfo> result = tradingAccountApi.getInterestRate(request);
    // 处理返回结果
}
```

## 返回字段说明

- `ccy`: 币种
- `interestRate`: 日利率

## 注意事项

1. 利率为日利率，实际计息可能按小时或更细粒度计算
2. 利率会根据市场情况和用户等级动态调整
3. 不同币种的利率可能差异较大
4. 利率信息实时更新，建议定期查询最新利率
5. 该接口返回的是用户当前适用的利率，可能因VIP等级而异

## 应用场景

- 借币成本评估
- 交易策略制定
- 风险管理中的成本计算
- 套利机会分析
- 资金成本优化

## 利率计算示例

假设BTC日利率为0.0001（0.01%），借币1000 USDT：
- 日利息 = 1000 × 0.0001 = 0.1 USDT
- 年化利率 = 0.01% × 365 = 3.65%

## 相关接口

- [获取计息记录API](interest-accrued-api.md) - 查看历史计息记录
- [获取产品最大可借API](max-loan-api.md) - 查看可借额度