package miven.java.array;

import org.junit.Test;

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
}
