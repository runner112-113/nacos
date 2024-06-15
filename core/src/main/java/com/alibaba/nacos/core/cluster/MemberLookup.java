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

package com.alibaba.nacos.core.cluster;

import com.alibaba.nacos.api.exception.NacosException;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Member node addressing mode.
 *
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 *
 * Nacos集群Member寻址机制
 */
public interface MemberLookup {
    
    /**
     * start.
     *
     * @throws NacosException NacosException
     */
    void start() throws NacosException;
    
    /**
     * is using address server.
     *
     * @return using address server or not.
     */
    boolean useAddressServer();
    
    /**
     * Inject the ServerMemberManager property.
     *
     * @param memberManager {@link ServerMemberManager}
     *
     * 将 ServerMemberManager 注入到 MemberLookup 中，
     * 方便利用ServerMemberManager 的存储、查询能力
     */
    void injectMemberManager(ServerMemberManager memberManager);
    
    /**
     * The addressing pattern finds cluster nodes.
     *
     * @param members {@link Collection}
     *
     * ⼀个事件接口，当 MemberLookup 需要进行成员节点信息更新时，会将当前最新的成员节点列表信息通过该函数进行通知给
     * ServerMemberManager，具体的节点管理方式，则是隐藏到具体的 MemberLookup 实现中。
     */
    void afterLookup(Collection<Member> members);
    
    /**
     * Addressing mode closed.
     *
     * @throws NacosException NacosException
     */
    void destroy() throws NacosException;
    
    /**
     * Some data information about the addressing pattern.
     *
     * @return {@link Map}
     */
    default Map<String, Object> info() {
        return Collections.emptyMap();
    }
    
}
