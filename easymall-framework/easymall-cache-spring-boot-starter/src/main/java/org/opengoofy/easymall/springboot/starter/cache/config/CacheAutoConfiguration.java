/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opengoofy.easymall.springboot.starter.cache.config;

import org.opengoofy.easymall.springboot.starter.cache.RedisKeySerializer;
import org.opengoofy.easymall.springboot.starter.cache.RedisTemplateProxy;
import lombok.AllArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 缓存配置自动装配
 *
 * @author chen.ma
 * @github https://github.com/agentart
 */
@AllArgsConstructor
@EnableConfigurationProperties({RedisDistributedProperties.class, BloomFilterPenetrateProperties.class})
public class CacheAutoConfiguration {
    
    private final RedisDistributedProperties redisDistributedProperties;
    
    /**
     * 创建 redis key 序列化器，可自定义 key prefix
     */
    @Bean
    public RedisKeySerializer redisKeySerializer() {
        String prefix = redisDistributedProperties.getPrefix();
        String prefixCharset = redisDistributedProperties.getPrefixCharset();
        return new RedisKeySerializer(prefix, prefixCharset);
    }
    
    /**
     * 防止缓存穿透的布隆过滤器
     */
    @Bean
    public RBloomFilter<String> cachePenetrationBloomFilter(RedissonClient redissonClient, BloomFilterPenetrateProperties bloomFilterPenetrateProperties) {
        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter(bloomFilterPenetrateProperties.getName());
        cachePenetrationBloomFilter.tryInit(bloomFilterPenetrateProperties.getExpectedInsertions(), bloomFilterPenetrateProperties.getFalseProbability());
        return cachePenetrationBloomFilter;
    }
    
    /**
     * redis 客户端代理类增强
     */
    @Bean
    public RedisTemplateProxy redisTemplateProxy(RedisKeySerializer redisKeySerializer,
                                                 StringRedisTemplate stringRedisTemplate,
                                                 RedissonClient redissonClient,
                                                 RBloomFilter<String> cachePenetrationBloomFilter) {
        stringRedisTemplate.setKeySerializer(redisKeySerializer);
        return new RedisTemplateProxy(stringRedisTemplate, redisDistributedProperties, redissonClient, cachePenetrationBloomFilter);
    }
}