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

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service instance metadata for v2.
 *
 * @author xiweng.yy
 */
public class InstanceMetadata implements Serializable {
    
    private static final long serialVersionUID = -8477858617353459226L;
    
    /**
     * instance weight.
     * 实例级别的配置。权重为浮点数，范围为 0-10000。
     * 权重越大，分配给该实例的流量越大
     */
    private double weight = 1.0D;
    
    /**
     * If instance is enabled to accept request.
     * 标记该实例是否接受流量，优先级大于权重和健康状态。
     * 用于运维人员在不变动实例本身的情况下，快速地手动将某个实例从服务中移除。
     */
    private boolean enabled = true;

    /**
     * user extended attributes.
     * 不同于实例定义中的拓展数据，这个拓展数据是给予运维人员在不变动
     * 实例本身的情况下，快速地修改和新增实例的扩展数据，从而达到运维实例的作用。
     */
    private Map<String, Object> extendData = new ConcurrentHashMap<>(1);
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public Map<String, Object> getExtendData() {
        return extendData;
    }
    
    public void setExtendData(Map<String, Object> extendData) {
        this.extendData = extendData;
    }
}
