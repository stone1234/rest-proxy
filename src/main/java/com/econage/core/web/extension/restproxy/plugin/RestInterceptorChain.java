/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.econage.core.web.extension.restproxy.plugin;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RestInterceptorChain {

  private final List<RestInterceptor> interceptors = new ArrayList<>();

  public Object pluginAll(Object target,Class<?> restInterface) {
    for (RestInterceptor interceptor : interceptors) {
      target = interceptor.plugin(target,restInterface);
    }
    return target;
  }

  public void addInterceptor(RestInterceptor interceptor) {
    interceptors.add(interceptor);
  }

  public List<RestInterceptor> getInterceptors() {
    return Collections.unmodifiableList(interceptors);
  }

}
