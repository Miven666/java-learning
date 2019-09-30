package miven.java.clazz;

import org.junit.Test;

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
}
