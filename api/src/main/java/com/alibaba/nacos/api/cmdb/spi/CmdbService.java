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

package com.alibaba.nacos.api.cmdb.spi;

import com.alibaba.nacos.api.cmdb.pojo.Entity;
import com.alibaba.nacos.api.cmdb.pojo.EntityEvent;
import com.alibaba.nacos.api.cmdb.pojo.Label;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service to visit CMDB store.
 *
 * @author nkorange
 * @since 0.7.0
 */
public interface CmdbService {
    
    /**
     * Get all label names stored in CMDB.
     *
     * @return label name set
     *
     * 获取标签列表
     * 这个方法将返回 CMDB 中需要被 Nacos 识别的标签名集合，CMDB 插件可以按需决定返回什么标
     * 签个 Nacos。不在这个集合的标签将会被 Nacos 忽略，即使这个标签出现在实体的属性里。我们
     * 允许这个集合会在运行时动态变化，Nacos 会定时去调用这个接口刷新标签集合。
     */
    Set<String> getLabelNames();
    
    /**
     * Get all possible entity types in CMDB.
     *
     * @return all entity types
     *
     * 获取实体类型
     * 获取 CMDB 里的实体的类型集合，不在这个集合的实体类型会被 Nacos 忽略。服务发现模块目前
     * 需要的实体类似是 ip，如果想要通过打通 CMDB 数据来实现服务的高级负载均衡，请务必在返回
     * 集合里包含 “ip”。
     */
    Set<String> getEntityTypes();
    
    /**
     * Get label info.
     *
     * @param labelName label name
     * @return label info
     *
     * 获取标签详情
     * 获取标签的详细信息。返回的 Label 类里包含标签的名字和标签值的集合。如果某个实体的这个标
     * 签的值不在标签值集合里，将会被视为无效。
     */
    Label getLabel(String labelName);
    
    /**
     * Get label value of label name of ip.
     *
     * @param entityName entity name
     * @param entityType entity type
     * @param labelName  target label name
     * @return label value
     *
     * 查询实体的标签值
     *
     * 这里包含两个方法，⼀个是获取实体某⼀个标签名对应的值，⼀个是获取实体所有标签的键值对。
     * 参数里包含实体的值和实体的类型。注意，这个方法并不会在每次在 Nacos 内部触发查询时去调
     * 用，Nacos 内部有⼀个 CMDB 数据的缓存，只有当这个缓存失效或者不存在时，才会去访问 CMDB
     * 插件查询数据。为了让 CMDB 插件的实现尽量简单，我们在 Nacos 内部实现了相应的缓存和刷新
     * 逻辑。
     */
    String getLabelValue(String entityName, String entityType, String labelName);
    
    /**
     * Get all label value of ip.
     *
     * @param entityName entity name
     * @param entityType entity type
     * @return all label values
     *
     * 查询实体的标签值
     */
    Map<String, String> getLabelValues(String entityName, String entityType);
    
    /**
     * Dump all entities in CMDB.
     *
     * @return all entities
     *
     * 查询实体
     * 查询实体包含两个方法：查询所有实体和查询单个实体。查询单个实体目前其实就是查询这个实体
     * 的所有标签，不过我们将这个方法与获取所有标签的方法区分开来，因为查询单个实体方法后面可
     * 能会进行扩展，比查询所有标签获取的信息要更多。
     *
     * 查询所有实体则是⼀次性将 CMDB 的所有数据拉取过来，该方法可能会比较消耗性能，无论是对于
     * Nacos 还是 CMDB。Nacos 内部调用该方法的策略是通过可配置的定时任务周期来定时拉取所有数
     * 据，在实现该 CMDB 插件时，也请关注 CMDB 服务本身的性能，采取合适的策略。
     */
    Map<String, Map<String, Entity>> getAllEntities();
    
    /**
     * get label change events.
     *
     * @param timestamp start time of generated events
     * @return label events
     *
     * 查询实体事件
     * 这个方法意在获取最近⼀段时间内实体的变更消息，增量的去拉取变更的实体。因为 Nacos 不会
     * 实时去访问 CMDB 插件查询实体，需要这个拉取事件的方法来获取实体的更新。参数里的 timesta
     * mp 为上⼀次拉取事件的时间，CMDB 插件可以选择使用或者忽略这个参数。
     */
    List<EntityEvent> getEntityEvents(long timestamp);
    
    /**
     * Get single entity.
     *
     * @param entityName name of entity
     * @param entityType type of entity
     * @return entity.
     */
    Entity getEntity(String entityName, String entityType);
}
