package miven.java.collection.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 *  Map 例子
 * @author mingzhi.xie
 * @date 2019/9/25
 * @since 1.0
 * @see java.util.Map
 */
class MapExample {

    static void putAndPutIfAbsent() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(2);
        map.put("key1", "11111");
        System.out.println("向 map 中 put(key1,11111)");
        map.put("key1", "22222");
        System.out.println("向 map 中 put(key1,22222)");
        System.out.println("现在 map 中 key1 对应 value 为 " + map.get("key1"));

        map.putIfAbsent("key2", "11111");
        System.out.println("向 map 中 putIfAbsent(key2,11111)");
        map.putIfAbsent("key2", "22222");
        System.out.println("向 map 中 putIfAbsent(key2,22222)");
        System.out.println("现在 map 中 key2 对应 value 为 " + map.get("key2"));
    }
}
