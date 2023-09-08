package com.example.foodi.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan
@EnableCaching
public class RedissonConfig {


    @Bean(destroyMethod="shutdown")
    RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }


        @Bean
        CacheManager cacheManager (RedissonClient redissonClient){
            Map<String, CacheConfig> config = new HashMap<>();

            // create "testMap" spring cache with ttl = 12 minutes and maxIdleTime = 8 minutes
            config.put("testMap", new CacheConfig(12 * 60 * 1000, 8 * 60 * 1000) );
            return new RedissonSpringCacheManager(redissonClient, config);

        }
    }