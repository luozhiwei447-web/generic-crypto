# 获取借币利息和限额API使用说明

## 接口描述

获取借币利息和限额接口用于查询指定产品类型和币种的借币利率、借币限额等信息。

## 接口信息

- **接口路径**: `/api/v5/account/interest-limits`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `type`: 产品类型（必填）
  - `MARGIN`: 币币杠杆
  - `VIP`: 尊享借币
- `ccy`: 币种（可选），如BTC，不填写表示查询所有币种

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询所有币币杠杆的借币利息和限额
public void getAllMarginBorrowInfo() {
    BorrowInterestLimitRequest request = new BorrowInterestLimitRequest()
        .setType(BorrowType.MARGIN.getValue());
    
    List<BorrowInterestLimitInfo> result = tradingAccountApi.getBorrowInterestLimit(request);
    // 处理返回结果
}

// 查询BTC币币杠杆的借币利息和限额
public void getBtcMarginBorrowInfo() {
    BorrowInterestLimitRequest request = new BorrowInterestLimitRequest()
        .setType(BorrowType.MARGIN.getValue())
        .setCcy("BTC");
    
    List<BorrowInterestLimitInfo> result = tradingAccountApi.getBorrowInterestLimit(request);
    // 处理返回结果
}

// 查询所有尊享借币的利息和限额
public void getAllVipBorrowInfo() {
    BorrowInterestLimitRequest request = new BorrowInterestLimitRequest()
        .setType(BorrowType.VIP.getValue());
    
    List<BorrowInterestLimitInfo> result = tradingAccountApi.getBorrowInterestLimit(request);
    // 处理返回结果
}

// 查询USDT尊享借币的利息和限额
public void getUsdtVipBorrowInfo() {
    BorrowInterestLimitRequest request = new BorrowInterestLimitRequest()
        .setType(BorrowType.VIP.getValue())
        .setCcy("USDT");
    
    List<BorrowInterestLimitInfo> result = tradingAccountApi.getBorrowInterestLimit(request);
    // 处理返回结果
}

// 分析借币成本和可用额度
public void analyzeBorrowCostAndLimit() {
    BorrowInterestLimitRequest request = new BorrowInterestLimitRequest()
        .setType(BorrowType.MARGIN.getValue())
        .setCcy("BTC");
    
    List<BorrowInterestLimitInfo> result = tradingAccountApi.getBorrowInterestLimit(request);
    
    if (!result.isEmpty()) {
        BorrowInterestLimitInfo info = result.get(0);
        
        System.out.println("币种: " + info.getCcy());
        System.out.println("日利率: " + info.getRate());
        System.out.println("借币限额: " + info.getLoanQuota());
        System.out.println("可借数量: " + info.getSurplusLmt());
        System.out.println("已借数量: " + info.getUsedLmt());
        
        // 计算年化利率
        double dailyRate = Double.parseDouble(info.getRate());
        double annualRate = dailyRate * 365 * 100;
        System.out.println("年化利率: " + annualRate + "%");
    }
}
```

## 返回字段说明

- `ccy`: 币种
- `rate`: 日利率
- `loanQuota`: 借币限额
- `surplusLmt`: 可借数量（剩余限额）
- `usedLmt`: 已借数量（已使用限额）
- `loanQuotaCoef`: 借币限额等级

## 产品类型说明

### 币币杠杆 (MARGIN)
- 用于币币杠杆交易的借币
- 利率相对较低
- 借币限额基于账户等级和资产状况

### 尊享借币 (VIP)
- 面向VIP用户的专享借币服务
- 可能享有更优惠的利率
- 更高的借币限额

## 注意事项

1. 利率为日利率，实际年化利率需要乘以365
2. 借币限额会根据用户等级和账户状况动态调整
3. 可借数量 = 借币限额 - 已借数量
4. 不同币种的利率和限额可能差异较大
5. VIP用户通常享有更优惠的借币条件

## 应用场景

- 借币成本评估
- 借币策略制定
- 资金成本计算
- 杠杆交易规划
- 风险管理中的成本控制

## 相关接口

- [获取利率API](interest-rate-api.md) - 查看当前借币利率
- [获取产品最大可借API](max-loan-api.md) - 查看最大可借数量
- [获取计息记录API](interest-accrued-api.md) - 查看历史计息记录

## 计算示例

假设BTC日利率为0.0001（0.01%）：
- 年化利率 = 0.0001 × 365 = 0.0365 = 3.65%
- 借币1 BTC一天的利息 = 1 × 0.0001 = 0.0001 BTC
- 借币1 BTC一年的利息 = 1 × 0.0365 = 0.0365 BTC