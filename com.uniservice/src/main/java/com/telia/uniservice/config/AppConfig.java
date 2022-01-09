package com.telia.uniservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.telia.uniservice.constants.Constants;

@Component
public class AppConfig
{
    @Bean
    public RestTemplate customRestTemplate()
    {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(Constants.HTTP_CONNECTION_TIMEOUT);
        httpRequestFactory.setConnectTimeout(Constants.HTTP_CONNECTION_TIMEOUT);
        httpRequestFactory.setReadTimeout(Constants.HTTP_CONNECTION_TIMEOUT);

        return new RestTemplate(httpRequestFactory);
    }
}