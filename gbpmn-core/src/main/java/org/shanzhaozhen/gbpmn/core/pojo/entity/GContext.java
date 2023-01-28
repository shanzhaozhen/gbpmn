package org.shanzhaozhen.gbpmn.core.pojo.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-28
 * @Description: 上下文对象
 */
public class GContext {

    private Map<String, Object> info = new ConcurrentHashMap<>();

    public Object getValue(String key) {
        return info.get(key);
    }

    public void putValue(String key, Object value) {
        info.put(key, value);
    }

}
