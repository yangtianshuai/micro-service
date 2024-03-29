package com.example.demo.adapter.config;

import api.config.cache.CacheUnit;
import api.config.cache.ICacheUnit;
import api.config.cache.MemoryCacheUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class CacheConfigration {
    @Bean
    public CacheUnit useCas() {
        ICacheUnit cache = new MemoryCacheUnit();
        CacheUnit cache_unit = new CacheUnit(cache);
        cache_unit.setOutTime(60*30);
        return cache_unit;
    }
}
