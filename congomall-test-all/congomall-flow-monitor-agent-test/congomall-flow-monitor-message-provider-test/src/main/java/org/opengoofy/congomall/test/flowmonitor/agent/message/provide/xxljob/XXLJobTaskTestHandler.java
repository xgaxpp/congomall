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

package org.opengoofy.congomall.test.flowmonitor.agent.message.provide.xxljob;

import com.alibaba.nacos.common.utils.ThreadUtils;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * XXL-Job 任务测试
 *
 * @author chen.ma
 * @github https://github.com/OpenGoofy
 */
@Slf4j
@Component
public class XXLJobTaskTestHandler extends IJobHandler {
    
    @XxlJob(value = "demoJobHandler")
    @Override
    public void execute() throws Exception {
        Random random = new Random();
        int nextInt = random.nextInt(50);
        ThreadUtils.sleep(nextInt);
        log.info("执行任务... sleep time: {}", nextInt);
        if (nextInt % 2 == 0) {
            throw new RuntimeException();
        }
    }
}