package com.hao.wxtemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplateBean() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        //处理请求返回中文乱码
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        //设置请求超时时间
        int timeOut = 10*1000;
        simpleClientHttpRequestFactory.setConnectTimeout(timeOut);
        simpleClientHttpRequestFactory.setReadTimeout(timeOut);
        restTemplate.setRequestFactory(simpleClientHttpRequestFactory);

        return restTemplate;
    }

}
