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

package org.opengoofy.congomall.biz.product.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.opengoofy.congomall.ddd.framework.core.domain.AggregateRoot;

/**
 * 商品评论聚合根
 *
 * @author chen.ma
 * @github <a href="https://github.com/opengoofy" />
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductComment implements AggregateRoot {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 上级id，一级评论为0
     */
    private Long parentId;
    
    /**
     * 商品id
     */
    private Long productId;
    
    /**
     * 商品sku id
     */
    private Long productSkuId;
    
    /**
     * 用户id
     */
    private Long customerUserId;
    
    /**
     * 点赞数
     */
    private Integer likeCount;
    
    /**
     * 回复数
     */
    private Integer replyCount;
    
    /**
     * 评分
     */
    private Integer star;
    
    /**
     * 评论
     */
    private String content;
    
    /**
     * 回复标识 0：用户 1：店家
     */
    private Integer commentFlag;
    
    /**
     * 匿名标识 0：匿名 1：不匿名
     */
    private Integer hideFlag;
    
    /**
     * 追加标识 0：否 1：是
     */
    private Integer appendFlag;
    
    /**
     * 评论图片/视频，json格式
     */
    private String resource;
}
