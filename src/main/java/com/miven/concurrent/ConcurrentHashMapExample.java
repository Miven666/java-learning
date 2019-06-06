package com.miven.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mingzhi.xie
 * @date 2019/6/6.
 */
public class ConcurrentHashMapExample {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("key1", "value1-v1");
        concurrentHashMap.put("key1", "value1-v2");

        for (String key : concurrentHashMap.keySet()) {
            System.out.println("key(" + key + "),value(" + concurrentHashMap.get(key) +").");
            System.out.println("普通 put 方法会覆盖之前的值。");
        }

        System.out.println("=========================================");
        concurrentHashMap.putIfAbsent("key1", "value1-v3");
        concurrentHashMap.putIfAbsent("key2", "value2-v1");
        for (String key : concurrentHashMap.keySet()) {
            System.out.println("key(" + key + "),value(" + concurrentHashMap.get(key) +").");
            System.out.println("putIfAbsent 方法只会在缺少 value 时才会添加指定值。");
        }
    }
}
