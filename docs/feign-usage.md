# Feign使用文档

## 1. 基本配置

### 1.1 依赖配置
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

### 1.2 启用Feign
```java
@SpringBootApplication
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## 2. 创建Feign客户端

### 2.1 基本用法
```java
@FeignClient(name = "api-service", url = "${api.base-url}")
public interface ApiClient {
    
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);
    
    @PostMapping("/users")
    User createUser(@RequestBody User user);
}
```

### 2.2 查询参数
```java
@GetMapping("/users")
List<User> getUsers(@RequestParam("page") int page, 
                   @RequestParam("size") int size);

@GetMapping("/users")
List<User> getUsers(@RequestParam Map<String, Object> params);
```

## 3. 拦截器使用

### 3.1 创建拦截器
```java
@Component
public class AuthInterceptor implements RequestInterceptor {
    
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + getToken());
        template.header("Timestamp", String.valueOf(System.currentTimeMillis()));
    }
}
```

### 3.2 配置拦截器
```java
@FeignClient(name = "api-service", 
            url = "${api.base-url}", 
            configuration = AuthInterceptor.class)
public interface ApiClient {
    // ...
}
```

## 4. 配置文件

```yaml
api:
  base-url: https://api.example.com

feign:
  client:
    config:
      default:
        connectTimeout: 5000
        readTimeout: 10000
        loggerLevel: basic
```

## 5. 错误处理

```java
@Component
public class CustomErrorDecoder implements ErrorDecoder {
    
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("请求参数错误");
            case 401:
                return new UnauthorizedException("未授权");
            default:
                return new Exception("未知错误");
        }
    }
}
```

## 6. 使用示例

```java
@Service
public class UserService {
    
    @Autowired
    private ApiClient apiClient;
    
    public User getUserById(Long id) {
        try {
            return apiClient.getUserById(id);
        } catch (FeignException.NotFound e) {
            throw new UserNotFoundException("用户不存在");
        }
    }
}
```