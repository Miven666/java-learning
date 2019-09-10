package miven.java.collection.list;

/**
 * ArrayList 例子
 *
 * @author mingzhi.xie
 * @date 2019/4/21
 */
class ArrayListExample {

    /**
     * 是否有显示实现指定接口
     * @param t Object
     * @param clazz clazz
     * @param <T> T
     * @return true:有，false:没有
     */
    <T> boolean hasInterface(T t, Class clazz) {
        Class<?>[] interfaces = t.getClass().getInterfaces();
        for (Class<?> c : interfaces) {
            if (c.equals(clazz)) {
                return true;
            }
        }

        return false;
    }
}
