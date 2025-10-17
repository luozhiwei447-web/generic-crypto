# 获取借币还币历史API使用说明

## 接口描述

获取借币还币历史接口用于查询账户的借币和还币操作历史记录，支持分页查询和币种筛选。

## 接口信息

- **接口路径**: `/api/v5/account/borrow-repay-history`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `ccy`: 币种（可选），如BTC，不填写表示查询所有币种
- `after`: 请求此时间戳之后的分页内容（可选），Unix时间戳的毫秒数格式
- `before`: 请求此时间戳之前的分页内容（可选），Unix时间戳的毫秒数格式
- `limit`: 返回结果的数量（可选），最大为100，默认100条

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 查询所有借币还币历史
public void getAllBorrowRepayHistory() {
    BorrowRepayHistoryRequest request = new BorrowRepayHistoryRequest()
        .setLimit("50");
    
    List<BorrowRepayHistoryInfo> result = tradingAccountApi.getBorrowRepayHistory(request);
    
    for (BorrowRepayHistoryInfo history : result) {
        System.out.println("币种: " + history.getCcy());
        System.out.println("操作: " + history.getSide());
        System.out.println("数量: " + history.getAmt());
        System.out.println("时间: " + history.getTs());
        System.out.println("---");
    }
}

// 查询BTC的借币还币历史
public void getBtcBorrowRepayHistory() {
    BorrowRepayHistoryRequest request = new BorrowRepayHistoryRequest()
        .setCcy("BTC")
        .setLimit("20");
    
    List<BorrowRepayHistoryInfo> result = tradingAccountApi.getBorrowRepayHistory(request);
    // 处理返回结果
}

// 查询指定时间范围的借币还币历史
public void getBorrowRepayHistoryByTimeRange() {
    BorrowRepayHistoryRequest request = new BorrowRepayHistoryRequest()
        .setAfter("1640995200000")  // 2022-01-01 00:00:00
        .setBefore("1672531200000") // 2023-01-01 00:00:00
        .setLimit("100");
    
    List<BorrowRepayHistoryInfo> result = tradingAccountApi.getBorrowRepayHistory(request);
    // 处理返回结果
}

// 分页查询借币还币历史
public void getBorrowRepayHistoryWithPagination() {
    String lastTimestamp = null;
    int pageSize = 50;
    
    do {
        BorrowRepayHistoryRequest request = new BorrowRepayHistoryRequest()
            .setLimit(String.valueOf(pageSize));
        
        if (lastTimestamp != null) {
            request.setAfter(lastTimestamp);
        }
        
        List<BorrowRepayHistoryInfo> result = tradingAccountApi.getBorrowRepayHistory(request);
        
        if (result.isEmpty()) {
            break;
        }
        
        // 处理当前页数据
        for (BorrowRepayHistoryInfo history : result) {
            processHistoryRecord(history);
        }
        
        // 更新最后一条记录的时间戳用于下一页查询
        lastTimestamp = result.get(result.size() - 1).getTs();
        
    } while (true);
}

// 分析借币还币历史
public void analyzeBorrowRepayHistory() {
    BorrowRepayHistoryRequest request = new BorrowRepayHistoryRequest()
        .setCcy("USDT")
        .setLimit("100");
    
    List<BorrowRepayHistoryInfo> result = tradingAccountApi.getBorrowRepayHistory(request);
    
    double totalBorrow = 0;
    double totalRepay = 0;
    int borrowCount = 0;
    int repayCount = 0;
    
    for (BorrowRepayHistoryInfo history : result) {
        double amount = Double.parseDouble(history.getAmt());
        
        if ("borrow".equals(history.getSide())) {
            totalBorrow += amount;
            borrowCount++;
        } else if ("repay".equals(history.getSide())) {
            totalRepay += amount;
            repayCount++;
        }
    }
    
    System.out.println("借币总额: " + totalBorrow);
    System.out.println("还币总额: " + totalRepay);
    System.out.println("借币次数: " + borrowCount);
    System.out.println("还币次数: " + repayCount);
    System.out.println("净借币: " + (totalBorrow - totalRepay));
}

private void processHistoryRecord(BorrowRepayHistoryInfo history) {
    // 处理单条历史记录的逻辑
    System.out.println("处理记录: " + history.getCcy() + " " + history.getSide() + " " + history.getAmt());
}
```

## 返回字段说明

- `ccy`: 币种
- `side`: 借币还币方向
  - `borrow`: 借币
  - `repay`: 还币
- `amt`: 借币还币数量
- `ts`: 操作时间，Unix时间戳的毫秒数格式

## 注意事项

1. 历史记录按时间倒序排列，最新的记录在前
2. 支持分页查询，建议使用时间戳进行精确分页
3. 最大单次查询100条记录
4. 可以通过币种参数筛选特定币种的历史记录
5. 时间戳参数用于分页控制，提高查询效率

## 应用场景

- 借币还币操作审计
- 资金流水分析
- 成本核算和统计
- 风险管理中的历史回顾
- 财务报表生成

## 数据分析示例

### 借币还币统计
```java
// 统计最近30天的借币还币情况
long thirtyDaysAgo = System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000;

BorrowRepayHistoryRequest request = new BorrowRepayHistoryRequest()
    .setAfter(String.valueOf(thirtyDaysAgo))
    .setLimit("100");

List<BorrowRepayHistoryInfo> result = tradingAccountApi.getBorrowRepayHistory(request);

Map<String, Double> borrowStats = new HashMap<>();
Map<String, Double> repayStats = new HashMap<>();

for (BorrowRepayHistoryInfo history : result) {
    String ccy = history.getCcy();
    double amount = Double.parseDouble(history.getAmt());
    
    if ("borrow".equals(history.getSide())) {
        borrowStats.merge(ccy, amount, Double::sum);
    } else {
        repayStats.merge(ccy, amount, Double::sum);
    }
}
```

## 相关接口

- [手动借币还币API](borrow-repay-api.md) - 执行借币还币操作
- [获取借币利息和限额API](borrow-interest-limit-api.md) - 查看借币成本和限额
- [获取计息记录API](interest-accrued-api.md) - 查看利息支出记录

## 最佳实践

1. **分页查询**
   - 使用合适的页面大小
   - 利用时间戳进行精确分页
   - 避免一次性查询过多数据

2. **数据分析**
   - 结合时间范围进行统计分析
   - 按币种分类统计借还情况
   - 计算净借币量和频率

3. **监控告警**
   - 监控异常的借币还币行为
   - 设置借币频率和数量的告警
   - 定期审计借币还币记录