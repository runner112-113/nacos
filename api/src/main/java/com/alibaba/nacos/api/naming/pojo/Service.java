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

package com.alibaba.nacos.api.naming.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Service of Nacos.
 *
 * <p>We introduce a 'service --> cluster --> instance' model, in which service stores a list of clusters, which contains a
 * list of instances.
 *
 * <p>Typically we put some unique properties between instances to service level.
 *
 * @author nkorange
 */
public class Service implements Serializable {
    
    private static final long serialVersionUID = -3470985546826874460L;
    
    /**
     * service name.
     */
    private String name;
    
    /**
     * protect threshold.
     * 为了防止因过多实例故障，导致所有流量全部流入剩余实例，继而造成流量压力将剩余实例被压垮形成的雪崩效应。
     * 应将健康保护阈值定义为⼀个 0 到 1之间的浮点数。当域名健康实例数占总服务实例数的比例小于该值时，无论实例是否健康，都会
     * 将这个实例返回给客户端。这样做虽然损失了⼀部分流量，但是保证了集群中剩余健康实例能正常工作
     */
    private float protectThreshold = 0.0F;
    
    /**
     * application name of this service.
     */
    private String appName;
    
    /**
     * Service group to classify services into different sets.
     */
    private String groupName;
    
    private Map<String, String> metadata = new HashMap<>();
    
    public Service() {
    }
    
    public Service(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public float getProtectThreshold() {
        return protectThreshold;
    }
    
    public void setProtectThreshold(float protectThreshold) {
        this.protectThreshold = protectThreshold;
    }
    
    public String getAppName() {
        return appName;
    }
    
    public void setAppName(String appName) {
        this.appName = appName;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public Map<String, String> getMetadata() {
        return metadata;
    }
    
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
    
    public void addMetadata(String key, String value) {
        this.metadata.put(key, value);
    }
    
    @Override
    public String toString() {
        return "Service{" + "name='" + name + '\'' + ", protectThreshold=" + protectThreshold + ", appName='" + appName
                + '\'' + ", groupName='" + groupName + '\'' + ", metadata=" + metadata + '}';
    }
}
