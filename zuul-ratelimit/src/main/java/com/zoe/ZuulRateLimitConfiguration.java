package com.zoe;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zoe
 **/
@Configuration
public class ZuulRateLimitConfiguration {

    @Bean
    public RateLimiterErrorHandler rateLimitErrorHandler() {
        return new DefaultRateLimiterErrorHandler() {
            @Override
            public void handleSaveError(String key, Exception e) {
                // custom code
            }

            @Override
            public void handleFetchError(String key, Exception e) {
                // custom code
            }

            @Override
            public void handleError(String msg, Exception e) {
                // custom code
            }
        };
    }

}
