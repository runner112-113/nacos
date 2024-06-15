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

/**
 * CMDB entity event.
 *
 * @author nkorange
 * @since 0.7.0
 *
 * 实体的标签的变更事件。当 CMDB 的实体属性发生变化，需要有⼀个事件机制来通知所有订阅方。
 * 为了保证实体事件携带的变更信息是最新准确的，这个事件里只会包含变更的实体的标识以及变更
 * 事件的类型，不会包含变更的标签的值。
 */
public class EntityEvent {
    
    private EntityEventType type;
    
    private String entityName;
    
    private String entityType;
    
    public EntityEventType getType() {
        return type;
    }
    
    public void setType(EntityEventType type) {
        this.type = type;
    }
    
    public String getEntityName() {
        return entityName;
    }
    
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    
    public String getEntityType() {
        return entityType;
    }
    
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
}
