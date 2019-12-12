package miven.java.collection.list;

import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * ArrayList 例子
 *
 * @author mingzhi.xie
 * @date 2019/4/21
 * @see java.util.ArrayList
 */
class ArrayListExample {
    /**
     * 是否有显示实现指定接口
     * @param t Object
     * @param clazz clazz
     * @param <T> T
     * @return true:有，false:没有
     */
    <T> boolean hasInterface(T t, Class<?> clazz) {
        Class<?>[] interfaces = t.getClass().getInterfaces();
        for (Class<?> c : interfaces) {
            if (c.equals(clazz)) {
                return true;
            }
        }

        return false;
    }

    /**
     * ArrayList 的 clone() 也是浅复制
     */
    @SuppressWarnings("unchecked")
    static void shallowCopy(ArrayList<Apple> list) {
        System.out.println("原数组的 hashCode: " + list.hashCode());
        System.out.println("原数组内部元素 Apple 的 id 为" + list.get(0).id + "、" + list.get(1).id);

        ArrayList<Apple> clone = (ArrayList<Apple>) list.clone();
        ArrayList<Apple> constructList = new ArrayList<>(list);
        HashSet<Apple> constructSet = new HashSet<>(list);
        System.out.println("克隆数组内部元素 Apple 的 id 为 " + list.get(0).id + "、" + list.get(1).id);
        System.out.println("list 构造数组内部元素 Apple 的 id 为 " + constructList.get(0).id + "、" + constructList.get(1).id);
        Iterator<Apple> iterator = constructSet.iterator();
        Apple setOne = iterator.next();
        Apple setTwo = iterator.next();
        System.out.println("set 构造数组内部元素 Apple 的 id 为 " + setOne.id + "、" + setTwo.id);
        System.out.println("修改克隆数组、list 构造数组、set 构造数组内部元素");
        clone.get(0).id = 3;
        clone.get(1).id = 4;
        constructList.get(0).id = 5;
        constructList.get(1).id = 6;
        setOne.id = 7;
        setTwo.id = 8;

        System.out.println("修改后原数组内部元素 Apple 的 id 为 " + list.get(0).id + "、" + list.get(1).id);
        System.out.println("修改后克隆数组内部元素 Apple 的 id 为 " + clone.get(0).id + "、" + clone.get(1).id);
        System.out.println("修改后 list 构造数组内部元素 Apple 的 id 为 " + constructList.get(0).id + "、" + constructList.get(1).id);
        System.out.println("修改后 set 构造数组内部元素 Apple 的 id 为 " + setOne.id + "、" + setTwo.id);

        System.out.println("克隆数组的 hashCode: " + clone.hashCode());
        System.out.println("list 构造数组的 hashCode: " + constructList.hashCode());
        System.out.println("set 构造数组的 hashCode: " + constructSet.hashCode());
        System.out.println("克隆前后 equals 结果: " + list.equals(clone));
        System.out.println("list 构造前后 equals 结果: " + list.equals(constructList));
        System.out.println("set 构造前后 equals 结果: false");
        System.out.println("克隆前后 == 结果: " + (list == clone));
        System.out.println("构造前后 == 结果: " + (list == constructList));
        System.out.println("构造前后 == 结果: false");
    }

    static void deepCopy(ArrayList<RedApple> list) {
        System.out.println("原数组的 hashCode: " + list.hashCode());
        System.out.println("原数组内部元素 Apple 的 id 为" + list.get(0).id + "、" + list.get(1).id);

        ArrayList<RedApple> clone = SerializationUtils.clone(list);
        System.out.println("克隆数组内部元素 Apple 的 id 为 " + list.get(0).id + "、" + list.get(1).id);
        System.out.println("修改克隆数组内部元素");
        clone.get(0).id = 3;
        clone.get(1).id = 4;

        System.out.println("修改后原数组内部元素 Apple 的 id 为 " + list.get(0).id + "、" + list.get(1).id);
        System.out.println("修改后克隆数组内部元素 Apple 的 id 为 " + clone.get(0).id + "、" + clone.get(1).id);

        System.out.println("克隆数组的 hashCode: " + clone.hashCode());
        System.out.println("克隆前后 equals 结果: " + list.equals(clone));
        System.out.println("克隆前后 == 结果: " + (list == clone));
    }
}
