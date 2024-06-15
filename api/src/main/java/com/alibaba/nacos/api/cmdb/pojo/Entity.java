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

package com.alibaba.nacos.api.cmdb.pojo;

import java.util.Map;

/**
 * CMDB entity.
 *
 * @author nkorange
 * @since 0.7.0
 *
 * 实体是作为 CMDB 里数据的承载方，在⼀般的 CMDB 中，⼀个实体可以指⼀个 IP、应用或者服务。
 * 而这个实体会有很多属性，例如 IP 的机房信息，服务的版本信息等。
 */
public class Entity {
    
    private String type;
    
    private String name;
    
    private Map<String, String> labels;
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Map<String, String> getLabels() {
        return labels;
    }
    
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
}
