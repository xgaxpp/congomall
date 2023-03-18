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

package org.opengoofy.congomall.biz.customer.user.application.service.handler.verify;

import org.opengoofy.congomall.biz.customer.user.application.req.UserVerifyCodeCommand;
import org.opengoofy.congomall.biz.customer.user.domain.common.CacheConstant;
import org.opengoofy.congomall.springboot.starter.designpattern.strategy.AbstractExecuteStrategy;
import org.springframework.stereotype.Component;

/**
 * 用户登录使用邮箱验证
 *
 * @author chen.ma
 * @github <a href="https://github.com/opengoofy" />
 * @公众号 马丁玩编程，关注回复：资料，领取后端技术专家成长手册
 */
@Component
public class MailLoginVerifyCommandHandler extends AbstractMailVerifySender implements AbstractExecuteStrategy<UserVerifyCodeCommand, Void> {
    
    @Override
    public String mark() {
        return "customer_user_login_verify_mail";
    }
    
    @Override
    public void execute(UserVerifyCodeCommand requestParam) {
        mailVerifySend(requestParam);
    }
    
    @Override
    protected String getCachePrefixKey() {
        return CacheConstant.LOGIN_USER_VERIFY_CODE;
    }
}
