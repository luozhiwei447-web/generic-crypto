# 获取计息记录API使用说明

## 接口描述

获取计息记录接口用于查询账户的借币计息历史记录，包括利息金额、利率等详细信息。

## 接口信息

- **接口路径**: `/api/v5/account/interest-accrued`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `instType`: 产品类型（可选）
  - `MARGIN`: 币币杠杆
  - `SWAP`: 永续合约
  - `FUTURES`: 交割合约
  - `OPTION`: 期权
- `ccy`: 币种（可选），如BTC
- `instId`: 产品ID（可选），如BTC-USDT
- `mgnMode`: 保证金模式（可选）
  - `isolated`: 逐仓模式
  - `cross`: 全仓模式
- `after`: 请求此时间戳之后的分页内容（可选），Unix时间戳的毫秒数格式
- `before`: 请求此时间戳之前的分页内容（可选），Unix时间戳的毫秒数格式
- `limit`: 返回结果的数量（可选），最大为100，默认100条

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询所有计息记录
public void getAllInterestAccrued() {
    InterestAccruedRequest request = new InterestAccruedRequest()
        .setLimit("50");
    
    List<InterestAccruedInfo> result = tradingAccountApi.getInterestAccrued(request);
    // 处理返回结果
}

// 查询BTC币种的计息记录
public void getBtcInterestAccrued() {
    InterestAccruedRequest request = new InterestAccruedRequest()
        .setCcy("BTC")
        .setLimit("20");
    
    List<InterestAccruedInfo> result = tradingAccountApi.getInterestAccrued(request);
    // 处理返回结果
}

// 查询杠杆交易计息记录
public void getMarginInterestAccrued() {
    InterestAccruedRequest request = new InterestAccruedRequest()
        .setInstType(InstrumentType.MARGIN.name())
        .setInstId("BTC-USDT")
        .setMgnMode(MarginMode.CROSS.getValue());
    
    List<InterestAccruedInfo> result = tradingAccountApi.getInterestAccrued(request);
    // 处理返回结果
}

// 查询永续合约计息记录
public void getSwapInterestAccrued() {
    InterestAccruedRequest request = new InterestAccruedRequest()
        .setInstType(InstrumentType.SWAP.name())
        .setInstId("BTC-USD-SWAP")
        .setMgnMode(MarginMode.ISOLATED.getValue());
    
    List<InterestAccruedInfo> result = tradingAccountApi.getInterestAccrued(request);
    // 处理返回结果
}

// 分页查询计息记录
public void getInterestAccruedWithPagination() {
    InterestAccruedRequest request = new InterestAccruedRequest()
        .setAfter("1640995200000")  // 2022-01-01 00:00:00
        .setBefore("1672531200000") // 2023-01-01 00:00:00
        .setLimit("100");
    
    List<InterestAccruedInfo> result = tradingAccountApi.getInterestAccrued(request);
    // 处理返回结果
}
```

## 返回字段说明

- `instType`: 产品类型
- `ccy`: 币种
- `instId`: 产品ID
- `mgnMode`: 保证金模式
- `interest`: 计息金额
- `interestTime`: 计息时间，Unix时间戳的毫秒数格式
- `rate`: 日利率
- `liab`: 负债金额
- `ts`: 数据返回时间，Unix时间戳的毫秒数格式

## 注意事项

1. 计息记录按时间倒序排列，最新的记录在前
2. 利率为日利率，实际计息可能按小时或更细粒度计算
3. 负债金额为计息时的借币余额
4. 支持多种筛选条件组合查询
5. 分页查询时建议使用时间戳进行精确控制

## 应用场景

- 借币成本分析
- 利息支出统计
- 财务报表生成
- 风险管理中的成本监控
- 交易策略的盈亏计算