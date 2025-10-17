# 持仓构建器趋势图API使用说明

## 接口描述

持仓构建器趋势图接口用于获取指定持仓在不同价格水平下的盈亏趋势数据，帮助用户可视化分析持仓的风险收益特征。

## 接口信息

- **接口路径**: `/api/v5/account/position-builder-graph`
- **请求方法**: GET
- **权限要求**: 需要读取权限

## 参数说明

- `instId`: 产品ID（必填），如BTC-USD-SWAP
- `posSide`: 持仓方向（必填）
  - `long`: 多头
  - `short`: 空头
  - `net`: 净持仓
- `sz`: 持仓数量（必填）

## 使用示例

```java
@Autowired
private TradingAccountApi tradingAccountApi;

// 获取BTC永续合约多头持仓趋势图数据
public void getBtcLongPositionTrend() {
    PositionTrendRequest request = new PositionTrendRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.LONG.getValue())
        .setSz("1");
    
    List<PositionTrendInfo> result = tradingAccountApi.getPositionTrend(request);
    
    System.out.println("BTC多头持仓趋势数据:");
    for (PositionTrendInfo trend : result) {
        System.out.println("价格: " + trend.getPx() + 
            ", 盈亏: " + trend.getUpl() + 
            ", 盈亏率: " + trend.getUplRatio() + "%");
    }
}

// 获取ETH永续合约空头持仓趋势图数据
public void getEthShortPositionTrend() {
    PositionTrendRequest request = new PositionTrendRequest()
        .setInstId("ETH-USD-SWAP")
        .setPosSide(PositionSide.SHORT.getValue())
        .setSz("10");
    
    List<PositionTrendInfo> result = tradingAccountApi.getPositionTrend(request);
    
    // 分析趋势数据
    analyzeTrendData(result);
}

// 比较不同持仓数量的趋势
public void comparePositionSizes() {
    String[] sizes = {"0.5", "1", "2", "5"};
    
    for (String size : sizes) {
        PositionTrendRequest request = new PositionTrendRequest()
            .setInstId("BTC-USD-SWAP")
            .setPosSide(PositionSide.LONG.getValue())
            .setSz(size);
        
        List<PositionTrendInfo> result = tradingAccountApi.getPositionTrend(request);
        
        System.out.println("持仓数量: " + size + " BTC");
        printTrendSummary(result);
        System.out.println("---");
    }
}

// 生成盈亏分析报告
public void generatePnlAnalysisReport() {
    PositionTrendRequest request = new PositionTrendRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.LONG.getValue())
        .setSz("1");
    
    List<PositionTrendInfo> result = tradingAccountApi.getPositionTrend(request);
    
    if (!result.isEmpty()) {
        // 找到盈亏平衡点
        double breakEvenPrice = findBreakEvenPrice(result);
        
        // 计算最大盈利和最大亏损
        double maxProfit = findMaxProfit(result);
        double maxLoss = findMaxLoss(result);
        
        // 计算风险收益比
        double riskRewardRatio = Math.abs(maxProfit / maxLoss);
        
        System.out.println("=== 盈亏分析报告 ===");
        System.out.println("盈亏平衡价格: $" + String.format("%.2f", breakEvenPrice));
        System.out.println("最大潜在盈利: $" + String.format("%.2f", maxProfit));
        System.out.println("最大潜在亏损: $" + String.format("%.2f", maxLoss));
        System.out.println("风险收益比: " + String.format("%.2f", riskRewardRatio));
    }
}

// 可视化趋势数据（生成图表数据）
public void generateChartData() {
    PositionTrendRequest request = new PositionTrendRequest()
        .setInstId("BTC-USD-SWAP")
        .setPosSide(PositionSide.LONG.getValue())
        .setSz("1");
    
    List<PositionTrendInfo> result = tradingAccountApi.getPositionTrend(request);
    
    // 准备图表数据
    List<ChartDataPoint> chartData = new ArrayList<>();
    
    for (PositionTrendInfo trend : result) {
        ChartDataPoint point = new ChartDataPoint();
        point.setX(Double.parseDouble(trend.getPx()));
        point.setY(Double.parseDouble(trend.getUpl()));
        chartData.add(point);
    }
    
    // 输出图表数据（可用于前端图表库）
    System.out.println("图表数据 (价格, 盈亏):");
    for (ChartDataPoint point : chartData) {
        System.out.println("[" + point.getX() + ", " + point.getY() + "]");
    }
}

// 辅助方法
private void analyzeTrendData(List<PositionTrendInfo> trendData) {
    if (trendData.isEmpty()) return;
    
    double totalUpl = 0;
    int profitablePoints = 0;
    
    for (PositionTrendInfo trend : trendData) {
        double upl = Double.parseDouble(trend.getUpl());
        totalUpl += upl;
        if (upl > 0) profitablePoints++;
    }
    
    double avgUpl = totalUpl / trendData.size();
    double profitProbability = (double) profitablePoints / trendData.size() * 100;
    
    System.out.println("平均盈亏: $" + String.format("%.2f", avgUpl));
    System.out.println("盈利概率: " + String.format("%.1f%%", profitProbability));
}

private void printTrendSummary(List<PositionTrendInfo> trendData) {
    if (trendData.isEmpty()) return;
    
    double minUpl = Double.MAX_VALUE;
    double maxUpl = Double.MIN_VALUE;
    
    for (PositionTrendInfo trend : trendData) {
        double upl = Double.parseDouble(trend.getUpl());
        minUpl = Math.min(minUpl, upl);
        maxUpl = Math.max(maxUpl, upl);
    }
    
    System.out.println("盈亏范围: $" + String.format("%.2f", minUpl) + 
        " ~ $" + String.format("%.2f", maxUpl));
}

private double findBreakEvenPrice(List<PositionTrendInfo> trendData) {
    for (PositionTrendInfo trend : trendData) {
        double upl = Double.parseDouble(trend.getUpl());
        if (Math.abs(upl) < 1.0) { // 接近盈亏平衡
            return Double.parseDouble(trend.getPx());
        }
    }
    return 0;
}

private double findMaxProfit(List<PositionTrendInfo> trendData) {
    return trendData.stream()
        .mapToDouble(t -> Double.parseDouble(t.getUpl()))
        .max()
        .orElse(0);
}

private double findMaxLoss(List<PositionTrendInfo> trendData) {
    return trendData.stream()
        .mapToDouble(t -> Double.parseDouble(t.getUpl()))
        .min()
        .orElse(0);
}

// 图表数据点类
public static class ChartDataPoint {
    private double x; // 价格
    private double y; // 盈亏
    
    // getters and setters
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
}
```

## 返回字段说明

- `instId`: 产品ID
- `posSide`: 持仓方向
- `sz`: 持仓数量
- `px`: 价格水平
- `upl`: 在该价格水平下的未实现盈亏
- `uplRatio`: 在该价格水平下的未实现盈亏率

## 应用场景

### 1. 风险可视化
- 直观展示持仓在不同价格下的盈亏情况
- 识别盈亏平衡点
- 评估最大风险敞口

### 2. 策略分析
- 比较不同持仓规模的风险收益特征
- 优化入场和出场点位
- 制定止损止盈策略

### 3. 教育培训
- 帮助理解杠杆交易的风险特征
- 演示价格波动对持仓的影响
- 培养风险意识

### 4. 决策支持
- 为交易决策提供数据支持
- 评估持仓的风险收益比
- 优化资金配置

## 数据分析技巧

### 1. 趋势分析
```java
// 分析盈亏趋势的斜率
public void analyzeTrendSlope(List<PositionTrendInfo> trendData) {
    if (trendData.size() < 2) return;
    
    for (int i = 1; i < trendData.size(); i++) {
        double px1 = Double.parseDouble(trendData.get(i-1).getPx());
        double px2 = Double.parseDouble(trendData.get(i).getPx());
        double upl1 = Double.parseDouble(trendData.get(i-1).getUpl());
        double upl2 = Double.parseDouble(trendData.get(i).getUpl());
        
        double slope = (upl2 - upl1) / (px2 - px1);
        System.out.println("价格区间 [" + px1 + ", " + px2 + "] 盈亏斜率: " + slope);
    }
}
```

### 2. 风险度量
```java
// 计算价值风险(VaR)
public double calculateVaR(List<PositionTrendInfo> trendData, double confidence) {
    List<Double> uplList = trendData.stream()
        .map(t -> Double.parseDouble(t.getUpl()))
        .sorted()
        .collect(Collectors.toList());
    
    int index = (int) ((1 - confidence) * uplList.size());
    return uplList.get(index);
}
```

## 注意事项

1. 趋势图数据基于当前市场条件计算
2. 实际交易中的盈亏可能因手续费、滑点等因素有所差异
3. 数据点数量和价格范围由系统自动确定
4. 建议结合实时市场数据进行分析
5. 趋势图仅供参考，不构成投资建议

## 相关接口

- [持仓构建器API](position-builder-api.md) - 模拟单点持仓计算
- [获取持仓信息API](positions-api.md) - 查看实际持仓
- [获取账户风险状态API](risk-state-api.md) - 监控账户风险