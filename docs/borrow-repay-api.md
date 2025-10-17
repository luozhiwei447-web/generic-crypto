# 手动借币还币API使用说明

## 接口描述

手动借币还币接口用于主动进行借币或还币操作，适用于自主借币模式下的资金管理。

## 接口信息

- **接口路径**: `/api/v5/account/borrow-repay`
- **请求方法**: POST
- **权限要求**: 需要交易权限

## 参数说明

- `ccy`: 币种（必填），如BTC
- `side`: 借币还币方向（必填）
  - `borrow`: 借币
  - `repay`: 还币
- `amt`: 借币还币数量（必填）

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 借币操作
public void borrowCurrency() {
    BorrowRepayRequest request = new BorrowRepayRequest()
        .setCcy("BTC")
        .setSide(BorrowRepaySide.BORROW.getValue())
        .setAmt("0.1");
    
    List<BorrowRepayInfo> result = tradingAccountApi.borrowRepay(request);
    
    if (!result.isEmpty()) {
        BorrowRepayInfo info = result.get(0);
        System.out.println("借币成功:");
        System.out.println("币种: " + info.getCcy());
        System.out.println("操作: " + info.getSide());
        System.out.println("数量: " + info.getAmt());
        System.out.println("操作后余额: " + info.getBal());
    }
}

// 还币操作
public void repayCurrency() {
    BorrowRepayRequest request = new BorrowRepayRequest()
        .setCcy("BTC")
        .setSide(BorrowRepaySide.REPAY.getValue())
        .setAmt("0.05");
    
    List<BorrowRepayInfo> result = tradingAccountApi.borrowRepay(request);
    
    if (!result.isEmpty()) {
        BorrowRepayInfo info = result.get(0);
        System.out.println("还币成功:");
        System.out.println("币种: " + info.getCcy());
        System.out.println("操作: " + info.getSide());
        System.out.println("数量: " + info.getAmt());
        System.out.println("操作后余额: " + info.getBal());
    }
}

// 批量借币操作
public void batchBorrow() {
    // 借BTC
    BorrowRepayRequest btcRequest = new BorrowRepayRequest()
        .setCcy("BTC")
        .setSide(BorrowRepaySide.BORROW.getValue())
        .setAmt("0.1");
    tradingAccountApi.borrowRepay(btcRequest);
    
    // 借USDT
    BorrowRepayRequest usdtRequest = new BorrowRepayRequest()
        .setCcy("USDT")
        .setSide(BorrowRepaySide.BORROW.getValue())
        .setAmt("1000");
    tradingAccountApi.borrowRepay(usdtRequest);
}

// 全额还币
public void repayAll() {
    // 先查询当前借币余额
    // 然后进行全额还币
    BorrowRepayRequest request = new BorrowRepayRequest()
        .setCcy("BTC")
        .setSide(BorrowRepaySide.REPAY.getValue())
        .setAmt("0.1"); // 实际应用中应该查询当前负债数量
    
    List<BorrowRepayInfo> result = tradingAccountApi.borrowRepay(request);
    // 处理返回结果
}

// 智能借币管理
public void smartBorrowManagement() {
    try {
        // 1. 检查可借额度
        // 2. 根据策略决定借币数量
        // 3. 执行借币操作
        BorrowRepayRequest request = new BorrowRepayRequest()
            .setCcy("USDT")
            .setSide(BorrowRepaySide.BORROW.getValue())
            .setAmt("5000");
        
        List<BorrowRepayInfo> result = tradingAccountApi.borrowRepay(request);
        
        if (!result.isEmpty()) {
            System.out.println("借币操作成功执行");
        }
    } catch (Exception e) {
        System.err.println("借币操作失败: " + e.getMessage());
        // 处理异常情况
    }
}
```

## 返回字段说明

- `ccy`: 币种
- `side`: 借币还币方向
- `amt`: 借币还币数量
- `bal`: 借币还币后余额

## 操作说明

### 借币 (borrow)
- 从平台借入指定数量的币种
- 需要确保有足够的借币额度
- 借币后开始计息
- 增加账户负债

### 还币 (repay)
- 归还之前借入的币种
- 需要确保账户有足够余额
- 减少利息支出
- 减少账户负债

## 注意事项

1. 借币前需要确保有足够的借币额度和抵押品
2. 还币时需要确保账户有足够的币种余额
3. 借币会产生利息，需要定期关注利息成本
4. 操作前建议先查询当前借币状态和可用额度
5. 大额操作可能需要分批进行以避免市场冲击

## 风险提示

1. **利息风险**: 借币会产生利息成本，需要合理控制借币时间
2. **强平风险**: 过度借币可能导致保证金率过低，触发强制平仓
3. **流动性风险**: 市场波动可能影响借币和还币的执行
4. **操作风险**: 错误的操作可能导致不必要的损失

## 应用场景

- 杠杆交易中的资金管理
- 套利策略中的资金调配
- 流动性管理和优化
- 利息成本控制
- 风险管理中的负债调整

## 相关接口

- [获取借币利息和限额API](borrow-interest-limit-api.md) - 查看借币成本和额度
- [获取借币还币历史API](borrow-repay-history-api.md) - 查看历史操作记录
- [获取计息记录API](interest-accrued-api.md) - 查看利息支出

## 最佳实践

1. **操作前检查**
   - 查询当前借币状态
   - 确认可用额度
   - 评估利息成本

2. **风险控制**
   - 合理控制借币比例
   - 设置止损机制
   - 定期评估风险

3. **成本优化**
   - 选择合适的借币时机
   - 及时还币减少利息
   - 比较不同币种的借币成本