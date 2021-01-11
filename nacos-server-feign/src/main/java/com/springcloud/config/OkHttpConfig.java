package com.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import feign.Feign;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import okhttp3.ConnectionPool;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;


/**
 * 配置okhttp连接池
 * ConnectionPool 默认创建五个线程，保持五分钟的长连接
 * */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class OkHttpConfig {

    @Bean
    public Encoder encoder(){
        return new FormEncoder();
    }

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
                //设置连接超时
                .connectTimeout(10, TimeUnit.SECONDS)
                //设置读超时
                .readTimeout(10, TimeUnit.SECONDS)
                //设置写超时
                .writeTimeout(10, TimeUnit.SECONDS)
                //是否自动重连
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES))
                .build();
    }

    @Bean
    public IRule myRule() {
        return new RandomRule();/**定义为随机*/
    }
}
