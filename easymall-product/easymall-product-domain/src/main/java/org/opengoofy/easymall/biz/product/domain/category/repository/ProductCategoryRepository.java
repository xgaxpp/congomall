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

package org.opengoofy.easymall.biz.product.domain.category.repository;

import org.opengoofy.easymall.biz.product.domain.category.entity.ProductCategory;

/**
 * 商品分类仓储层
 *
 * @author chen.ma
 * @github https://github.com/agentart
 */
public interface ProductCategoryRepository {
    
    /**
     * 查询所有商品分类信息
     *
     * @return
     */
    ProductCategory listAllProductCategory();
}