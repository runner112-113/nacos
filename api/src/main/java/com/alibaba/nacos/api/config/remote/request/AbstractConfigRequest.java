/*
 * Copyright 1999-2023 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.nacos.api.config.remote.request;

import com.alibaba.nacos.api.common.Constants;
import com.alibaba.nacos.api.remote.request.Request;

/**
 * abstract request of config module request,all config module request should extends this class.
 *
 * @author liuzunfei
 * @version $Id: ConfigCommonRequest.java, v 0.1 2020年07月13日 9:05 PM liuzunfei Exp $
 */
public abstract class AbstractConfigRequest extends Request {

    /**
     * 配置 ID
     */
    private String dataId;

    /**
     * 配置分组
     */
    private String group;

    /**
     * 租户信息，对应 Nacos 的命名空间ID字段
     */
    private String tenant;
    
    public String getDataId() {
        return dataId;
    }
    
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public String getTenant() {
        return tenant;
    }
    
    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
    
    @Override
    public String getModule() {
        return Constants.Config.CONFIG_MODULE;
    }
}
