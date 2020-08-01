package miven.java.clazz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassExample测试类
 */
public class ClassExampleTest {

    private ClassExample classExample = new ClassExample();

    /**
     * 测试 getName()
     */
    @Test
    public void showGetNameMethodTest() {
        System.out.println(this.classExample.getNameMethod());
    }

    /**
     * 测试 getSimpleName()
     */
    @Test
    public void showGetSimpleNameMethod() {
        System.out.println(this.classExample.getSimpleNameMethod());
    }

    @Test
    public void TestAssignable() {
        // false
        System.out.println(ArrayList.class.isAssignableFrom(List.class));
        // true
        System.out.println(List.class.isAssignableFrom(ArrayList.class));
    }
}
