package com.ray.crypto.interceptor;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.format.DateParser;
import com.ray.crypto.common.constants.HmacAlgorithm;
import com.ray.crypto.common.mudules.config.CryptoProperties;
import com.ray.crypto.common.utils.SignatureUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DatePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

import static java.time.ZoneOffset.UTC;

/**
 * 加密Feign拦截器
 * 
 * @author ray
 * @date 2024-01-01
 */
@Slf4j
@Component
public class OkxFeignInterceptor implements RequestInterceptor {

    private final String ACCESS_KEY="OK-ACCESS-KEY";
    private final String ACCESS_SIGN="OK-ACCESS-SIGN";
    private final String ACCESS_TIMESTAMP="OK-ACCESS-TIMESTAMP";
    private final String ACCESS_PASSPHRASE="OK-ACCESS-PASSPHRASE";

    @Autowired
    @Qualifier("okxCryptoProperties")
    private CryptoProperties okxCryptoProperties;

    @Override
    public void apply(RequestTemplate template) {
        // 获取请求参数
        String queryParams = template.queryLine();

        // 生成时间戳
        String timestamp = Instant.now().truncatedTo(ChronoUnit.MILLIS).toString();

        // 构建签名字符串
        String signString = buildSignString(template.method(), template.path(), queryParams, timestamp);
        
        // 生成签名
        String signature = SignatureUtils.hmacSha256(signString,okxCryptoProperties.getApiSecret());
        signature=SignatureUtils.base64Encode(signature);
        
        // 添加认证头
        template.header(ACCESS_TIMESTAMP, timestamp);
        template.header(ACCESS_SIGN, signature);
        template.header(ACCESS_KEY, okxCryptoProperties.getApiKey());
        template.header(ACCESS_PASSPHRASE, okxCryptoProperties.getPassphrase());
        
        log.debug("Feign request encrypted - Method: {}, Path: {}, Signature: {}", 
                template.method(), template.path(), signature);
    }
    
    /**
     * 构建签名字符串
     */
    private String buildSignString(String method, String path, String queryParams, String timestamp) {
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp)
          .append(method)
          .append(path);
        
        if (queryParams != null && !queryParams.isEmpty()) {
            sb.append("?").append(queryParams);
        }
        
        return sb.toString();
    }
}