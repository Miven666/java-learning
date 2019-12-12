package miven.java.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组 测试类
 */
public class ArrayExampleTest {

    private int[] defaultBaseArr = {1, 2, 3, 4, 5};
    private Person[] defaultRefArr = {
            new Person("11"),
            new Person("22"),
            new Person("33"),
            new Person("44"),
            new Person("55")
    };

    private ArrayExample example = new ArrayExample();

    /**
     * copyOf() 测试
     */
    @Test
    public void copyOfTest() {
        example.baseTypeCopy(defaultBaseArr);
        System.out.println();
        System.out.println("---------分割符----------");
        System.out.println();
        example.referenceTypeCopy(defaultRefArr);
    }

    /**
     * clone() 测试
     */
    @Test
    public void cloneTest() {
        example.baseTypeClone(defaultBaseArr);
        System.out.println();
        System.out.println("---------分割符----------");
        System.out.println();
        example.referenceTypeClone(defaultRefArr);
    }

    /**
     * 并发修改异常测试
     */
    @Test
    public void concurrentModificationExceptionTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> subList = list.subList(2, list.size());
        System.out.println(subList);

        // 截取之后，一旦原集合新增或删除元素，则子集合不可再操作（新增、修改、删除）
        // list.add(88);
        list.remove(1);

        // 更新不影响
        list.set(1, 99);

        // 此处会发生并发修改异常，主要是影响背后数组的索引
        // subList.add(100);
        // subList.remove(1);
        subList.set(1, 55);

        System.out.println(subList);
        System.out.println(list);
    }
}
