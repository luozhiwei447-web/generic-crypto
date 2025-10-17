package com.ray.crypto.decoder;

import com.alibaba.fastjson2.JSON;
import com.ray.crypto.module.OkxResponse;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * OKX响应解码器，统一处理返回数据
 * 
 * @author ray
 * @date 2024-01-01
 */
@Slf4j
@Component
public class OkxResponseDecoder implements Decoder {



    @Override
    public Object decode(Response response, Type type) throws IOException {
        if (response.body() == null) {
            return null;
        }

        String responseBody = new String(response.body().asInputStream().readAllBytes());
        log.debug("OKX API原始响应: {}", responseBody);

        // 解析为OkxResponse
        OkxResponse<?> okxResponse = JSON.parseObject(responseBody, OkxResponse.class);
        
        // 统一处理错误
        if (!"0".equals(okxResponse.getCode())) {
            log.error("OKX API调用失败: code={}, msg={}", okxResponse.getCode(), okxResponse.getMsg());
            throw new DecodeException(response.status(), "OKX API错误: " + okxResponse.getMsg(), response.request());
        }

        // 否则直接返回data部分
        return okxResponse.getData();
    }
}