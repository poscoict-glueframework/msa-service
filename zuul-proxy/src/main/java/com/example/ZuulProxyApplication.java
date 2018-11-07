package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.filter.MyPostFilter;
import com.example.filter.MyPreFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulProxyApplication
{
    @Bean
    public MyPreFilter myPreFilter()
    {
        return new MyPreFilter();
    }

    @Bean
    public MyPostFilter myPostFilter()
    {
        return new MyPostFilter();
    }

    public static void main( String[] args )
    {
        SpringApplication.run( ZuulProxyApplication.class, args );
    }
}
