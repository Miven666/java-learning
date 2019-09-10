package miven.java.collection.list;

import org.junit.Test;

public class ArrayListExampleTest {
    private ArrayListExample example = new ArrayListExample();
    private Apple apple = new Apple();
    private RedApple redApple = new RedApple();
    private GreenApple greenApple = new GreenApple();
    private Class clazz = Call.class;

    @Test
    public void reflectionTest() {
        System.out.println("App has Call interface: " + example.hasInterface(apple, clazz));
        System.out.println("RedApple has Call interface: " + example.hasInterface(redApple, clazz));
        System.out.println("GreenApple has Call interface: " + example.hasInterface(greenApple, clazz));
    }
}
