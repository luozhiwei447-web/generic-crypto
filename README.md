# Generic Crypto

一个通用的加密货币交易所API集成框架，支持多个主流交易所的API调用。

## 项目简介

Generic Crypto是一个基于Spring Boot 3.5.6和Java 17开发的多模块项目，旨在提供统一的接口来访问不同加密货币交易所的API。目前已集成OKX交易所，后续将支持更多交易所。

## 技术栈

- **Java**: 17
- **Spring Boot**: 3.5.6
- **Spring Cloud**: 2025.0.0
- **OpenFeign**: 4.2.0
- **Maven**: 多模块项目管理
- **Lombok**: 简化代码编写
- **Hutool**: 工具类库
- **Logback**: 日志框架

## 项目架构

```
generic-crypto/
├── generic-crypto-common/     # 公共模块
│   ├── constants/            # 常量定义
│   ├── exception/           # 异常处理
│   ├── modules/            # 通用模块
│   └── utils/              # 工具类
├── generic-crypto-core/      # 核心模块
│   ├── config/             # 配置类
│   └── exception/          # 全局异常处理
├── generic-crypto-okx/       # OKX交易所集成
│   ├── api/                # API接口定义
│   ├── constants/          # OKX相关常量
│   ├── interceptor/        # 请求拦截器
│   └── module/             # 数据模型
├── generic-crypto-start/     # 启动模块
│   └── resources/          # 配置文件
└── docs/                    # 文档
```

## 核心功能

### 1. 统一API接口
- 提供统一的交易所API调用接口
- 支持多种交易产品类型（现货、期货、期权等）
- 标准化的请求和响应格式

### 2. 安全认证
- HMAC-SHA256签名算法
- 自动添加时间戳和签名头
- 支持API Key和Secret配置

### 3. 错误处理
- 全局异常处理机制
- 统一的错误码和错误信息
- 详细的日志记录

### 4. 配置管理
- 支持多环境配置
- 灵活的交易所配置
- 条件化Bean装配

## 快速开始

### 1. 环境要求

- JDK 17+
- Maven 3.6+

### 2. 克隆项目

```bash
git clone <repository-url>
cd generic-crypto
```

### 3. 编译项目

```bash
./mvnw clean compile
```

### 4. 配置文件

在 `generic-crypto-start/src/main/resources/application-local.yml` 中配置交易所信息：

```yaml
crypto:
  okx:
    web-url: https://www.okx.com
    api-key: your-api-key
    secret-key: your-secret-key
    passphrase: your-passphrase
```

### 5. 运行项目

```bash
./mvnw spring-boot:run -pl generic-crypto-start
```

## 使用示例

### 获取交易产品信息

```java
@Autowired
private TradingAccountApi tradingAccountApi;

public void getInstruments() {
    InstrumentRequest request = new InstrumentRequest();
    request.setInstType(InstrumentType.SPOT);
    
    InstrumentInfo result = tradingAccountApi.instruments(request);
    // 处理返回结果
}
```

### 下单交易

```java
@Autowired
private TradingApi tradingApi;

// 单笔下单
public void placeOrder() {
    PlaceOrderRequest request = new PlaceOrderRequest();
    request.setInstId("BTC-USDT");
    request.setTdMode(TradeMode.CASH);
    request.setSide(OrderSide.BUY);
    request.setOrdType(OrderType.LIMIT);
    request.setSz("0.01");
    request.setPx("50000");
    
    OkxResponse<List<PlaceOrderInfo>> response = tradingApi.placeOrder(request);
    // 处理返回结果
}

// 批量下单
public void placeBatchOrders() {
    List<PlaceOrderRequest> requests = Arrays.asList(
        createOrderRequest("BTC-USDT", "0.01", "50000"),
        createOrderRequest("ETH-USDT", "0.1", "3000")
    );
    
    OkxResponse<List<PlaceOrderInfo>> response = tradingApi.placeBatchOrders(requests);
    // 处理返回结果
}
```

## API文档

详细的API使用文档请参考：
- [Feign使用文档](docs/feign-usage.md)
- [交易API使用文档](docs/trading-api-usage.md)

## 开发规范

本项目遵循以下开发规范：
- [阿里巴巴Java开发规范](.amazonq/rules/alibaba-java-standards.md)
- [项目自定义规则](.amazonq/rules/custom-rules.md)

## 模块说明

### generic-crypto-common
公共模块，包含：
- 通用常量定义
- 异常类定义
- 工具类（签名、编码等）
- 通用配置类

### generic-crypto-core
核心模块，包含：
- 全局配置
- 全局异常处理
- 核心业务逻辑

### generic-crypto-okx
OKX交易所集成模块，包含：
- OKX API接口定义
- 请求拦截器
- 数据模型定义
- 常量定义

### generic-crypto-start
启动模块，包含：
- 应用启动类
- 配置文件
- 日志配置

## 贡献指南

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 创建 Pull Request

## 许可证

本项目采用 Apache License 2.0 许可证。详情请参阅 [LICENSE](LICENSE) 文件。

## 联系方式

- 作者：Ray
- 邮箱：[your-email@example.com]
- 项目地址：[项目仓库地址]

## 更新日志

### v0.0.1-SNAPSHOT
- 初始版本
- 集成OKX交易所API
- 实现基础的交易产品信息查询功能
- 添加HMAC-SHA256签名支持
- 集成OKX下单API
- 添加订单相关常量枚举
