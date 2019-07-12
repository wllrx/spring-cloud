package com.zoe.controller;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class GlobalFallback implements FallbackProvider {
    /**
     *  配置为哪个服务提供回退,*表示所有服务
     * @return .
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /*
       回退返回
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            //响应码
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }
            //数字类型响应码
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            //状态文本
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            //不处理
            @Override
            public void close() {

            }

            //响应体
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务器异常请稍后再试".getBytes(StandardCharsets.UTF_8));
            }

            //响应头
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
