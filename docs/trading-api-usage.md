# 交易API使用文档

## 下单API

### 接口说明
- **接口路径**: `/api/v5/trade/order`
- **请求方式**: POST
- **接口描述**: 下单交易

### 使用示例

#### 单笔下单

```java
@Autowired
private TradingApi tradingApi;

public void placeOrder() {
    PlaceOrderRequest request = new PlaceOrderRequest();
    
    // 必填参数
    request.setInstId("BTC-USDT");           // 产品ID
    request.setTdMode(TradeMode.CASH);       // 交易模式：现金
    request.setSide(OrderSide.BUY);          // 订单方向：买入
    request.setOrdType(OrderType.LIMIT);     // 订单类型：限价单
    request.setSz("0.01");                   // 委托数量
    request.setPx("50000");                  // 委托价格
    
    // 可选参数
    request.setClOrdId("custom_order_123");  // 客户自定义订单ID
    request.setTag("my_order");              // 订单标签
    request.setPosSide(PositionSide.NET);    // 持仓方向：净持仓
    
    try {
        OkxResponse<List<PlaceOrderInfo>> response = tradingApi.placeOrder(request);
        
        if ("0".equals(response.getCode())) {
            // 下单成功
            List<PlaceOrderInfo> orderInfos = response.getData();
            for (PlaceOrderInfo orderInfo : orderInfos) {
                System.out.println("订单ID: " + orderInfo.getOrdId());
                System.out.println("客户订单ID: " + orderInfo.getClOrdId());
                System.out.println("订单状态: " + orderInfo.getSCode());
            }
        } else {
            // 下单失败
            System.err.println("下单失败: " + response.getMsg());
        }
    } catch (Exception e) {
        System.err.println("API调用异常: " + e.getMessage());
    }
}
```

#### 批量下单

```java
@Autowired
private TradingApi tradingApi;

public void placeBatchOrders() {
    List<PlaceOrderRequest> requests = new ArrayList<>();
    
    // 第一个订单
    PlaceOrderRequest order1 = new PlaceOrderRequest();
    order1.setInstId("BTC-USDT");
    order1.setTdMode(TradeMode.CASH);
    order1.setSide(OrderSide.BUY);
    order1.setOrdType(OrderType.LIMIT);
    order1.setSz("0.01");
    order1.setPx("50000");
    order1.setClOrdId("batch_order_1");
    
    // 第二个订单
    PlaceOrderRequest order2 = new PlaceOrderRequest();
    order2.setInstId("ETH-USDT");
    order2.setTdMode(TradeMode.CASH);
    order2.setSide(OrderSide.BUY);
    order2.setOrdType(OrderType.LIMIT);
    order2.setSz("0.1");
    order2.setPx("3000");
    order2.setClOrdId("batch_order_2");
    
    requests.add(order1);
    requests.add(order2);
    
    try {
        OkxResponse<List<PlaceOrderInfo>> response = tradingApi.placeBatchOrders(requests);
        
        if ("0".equals(response.getCode())) {
            // 批量下单成功
            List<PlaceOrderInfo> orderInfos = response.getData();
            for (PlaceOrderInfo orderInfo : orderInfos) {
                System.out.println("订单ID: " + orderInfo.getOrdId());
                System.out.println("客户订单ID: " + orderInfo.getClOrdId());
                System.out.println("订单状态: " + orderInfo.getSCode());
                System.out.println("---");
            }
        } else {
            // 批量下单失败
            System.err.println("批量下单失败: " + response.getMsg());
        }
    } catch (Exception e) {
        System.err.println("API调用异常: " + e.getMessage());
    }
}
```

#### 单笔撤单

```java
@Autowired
private TradingApi tradingApi;

public void cancelOrder() {
    CancelOrderRequest request = new CancelOrderRequest();
    request.setInstId("BTC-USDT");           // 产品ID
    request.setOrdId("123456789");           // 订单ID
    // 或者使用客户自定义订单ID
    // request.setClOrdId("custom_order_123");
    
    try {
        OkxResponse<List<CancelOrderInfo>> response = tradingApi.cancelOrder(request);
        
        if ("0".equals(response.getCode())) {
            // 撤单成功
            List<CancelOrderInfo> cancelInfos = response.getData();
            for (CancelOrderInfo cancelInfo : cancelInfos) {
                System.out.println("订单ID: " + cancelInfo.getOrdId());
                System.out.println("客户订单ID: " + cancelInfo.getClOrdId());
                System.out.println("撤单状态: " + cancelInfo.getSCode());
            }
        } else {
            // 撤单失败
            System.err.println("撤单失败: " + response.getMsg());
        }
    } catch (Exception e) {
        System.err.println("API调用异常: " + e.getMessage());
    }
}
```

#### 批量撤单

```java
@Autowired
private TradingApi tradingApi;

public void cancelBatchOrders() {
    List<CancelOrderRequest> requests = new ArrayList<>();
    
    // 第一个撤单请求
    CancelOrderRequest cancel1 = new CancelOrderRequest();
    cancel1.setInstId("BTC-USDT");
    cancel1.setOrdId("123456789");
    
    // 第二个撤单请求
    CancelOrderRequest cancel2 = new CancelOrderRequest();
    cancel2.setInstId("ETH-USDT");
    cancel2.setClOrdId("custom_order_456");
    
    requests.add(cancel1);
    requests.add(cancel2);
    
    try {
        OkxResponse<List<CancelOrderInfo>> response = tradingApi.cancelBatchOrders(requests);
        
        if ("0".equals(response.getCode())) {
            // 批量撤单成功
            List<CancelOrderInfo> cancelInfos = response.getData();
            for (CancelOrderInfo cancelInfo : cancelInfos) {
                System.out.println("订单ID: " + cancelInfo.getOrdId());
                System.out.println("客户订单ID: " + cancelInfo.getClOrdId());
                System.out.println("撤单状态: " + cancelInfo.getSCode());
                System.out.println("---");
            }
        } else {
            // 批量撤单失败
            System.err.println("批量撤单失败: " + response.getMsg());
        }
    } catch (Exception e) {
        System.err.println("API调用异常: " + e.getMessage());
    }
}
```

### 参数说明

#### 请求参数 (PlaceOrderRequest)

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| instId | String | 是 | 产品ID，如 BTC-USDT |
| tdMode | String | 是 | 交易模式：cash(现金)、isolated(逐仓)、cross(全仓) |
| side | String | 是 | 订单方向：buy(买入)、sell(卖出) |
| ordType | String | 是 | 订单类型：market(市价)、limit(限价)、post_only等 |
| sz | String | 是 | 委托数量 |
| px | String | 否 | 委托价格，市价单不需要 |
| posSide | String | 否 | 持仓方向：long(多头)、short(空头)、net(净持仓) |
| clOrdId | String | 否 | 客户自定义订单ID |
| tag | String | 否 | 订单标签 |

#### 响应参数 (PlaceOrderInfo)

| 参数名 | 类型 | 说明 |
|--------|------|------|
| ordId | String | 订单ID |
| clOrdId | String | 客户自定义订单ID |
| tag | String | 订单标签 |
| ts | String | 系统处理时间戳 |
| sCode | String | 事件执行结果码，0代表成功 |
| sMsg | String | 事件执行结果信息 |

### 常用枚举值

#### 交易模式 (TradeMode)
- `cash`: 现金交易
- `isolated`: 逐仓保证金
- `cross`: 全仓保证金

#### 订单方向 (OrderSide)
- `buy`: 买入
- `sell`: 卖出

#### 订单类型 (OrderType)
- `market`: 市价单
- `limit`: 限价单
- `post_only`: 只做maker单
- `fok`: 全部成交或立即取消
- `ioc`: 立即成交并取消剩余

### API接口说明

#### 单笔下单
- **接口路径**: `/api/v5/trade/order`
- **请求方式**: POST
- **参数**: PlaceOrderRequest对象

#### 批量下单
- **接口路径**: `/api/v5/trade/batch-orders`
- **请求方式**: POST
- **参数**: PlaceOrderRequest对象数组
- **限制**: 最多同时下20个订单

### 注意事项

1. 所有价格和数量参数都使用字符串类型，避免精度丢失
2. 市价单不需要设置委托价格(px)参数
3. 客户自定义订单ID(clOrdId)可用于订单追踪和管理
4. 批量下单最多同时下20个订单，超出限制会返回错误
5. 批量下单中的每个订单都会独立处理，部分成功部分失败是正常情况
6. 请确保API密钥有交易权限
7. 建议在生产环境使用前先在测试环境验证