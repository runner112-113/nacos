/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
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

package com.alibaba.nacos.naming.core.v2.metadata;

import com.alibaba.nacos.api.naming.pojo.healthcheck.AbstractHealthChecker;
import com.alibaba.nacos.api.naming.pojo.healthcheck.impl.Tcp;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service cluster metadata for v2.
 *
 * @author xiweng.yy
 */
public class ClusterMetadata implements Serializable {
    
    private static final long serialVersionUID = -80030989533083615L;

    /**
     * 设置用于健康检查的端口
     */
    private int healthyCheckPort = 80;

    /**
     * 使用哪种类型的健康检查方式，目前支持：TCP，HTTP，MySQL；
     * 设置为 NONE 可以关闭健康检查
     */
    private String healthyCheckType = Tcp.TYPE;
    
    private AbstractHealthChecker healthChecker = new Tcp();
    
    /**
     * Whether or not use instance port to do health check.
     * 是否使用实例端口进行健康检查：如果使用实例端口进行健康检查，将会使用实例定义中的网络端口进行健康检查，而不再使用上述设置的健康检查端口进行
     */
    private boolean useInstancePortForCheck = true;

    /**
     * ：用于用户自定义扩展的元数据内容，形式为 K-V 。
     * 可以自定义扩展该集群的元数据信息，方便用户实现自己的自定义逻辑和标示该集群。
     */
    private Map<String, String> extendData = new ConcurrentHashMap<>(1);
    
    public int getHealthyCheckPort() {
        return healthyCheckPort;
    }
    
    public void setHealthyCheckPort(int healthyCheckPort) {
        this.healthyCheckPort = healthyCheckPort;
    }
    
    public String getHealthyCheckType() {
        return healthyCheckType;
    }
    
    public void setHealthyCheckType(String healthyCheckType) {
        this.healthyCheckType = healthyCheckType;
    }
    
    public AbstractHealthChecker getHealthChecker() {
        return healthChecker;
    }
    
    public void setHealthChecker(AbstractHealthChecker healthChecker) {
        this.healthChecker = healthChecker;
    }
    
    public boolean isUseInstancePortForCheck() {
        return useInstancePortForCheck;
    }
    
    public void setUseInstancePortForCheck(boolean useInstancePortForCheck) {
        this.useInstancePortForCheck = useInstancePortForCheck;
    }
    
    public Map<String, String> getExtendData() {
        return extendData;
    }
    
    public void setExtendData(Map<String, String> extendData) {
        this.extendData = extendData;
    }
}
