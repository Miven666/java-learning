package miven.java.collection.list;

import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void shallowCopyTest() {
        ArrayList<Apple> apples = new ArrayList<>(2);
        apples.add(new Apple(1));
        apples.add(new Apple(2));
        ArrayListExample.shallowCopy(apples);
    }
    @Test
    public void deepCopyTest() {
        ArrayList<RedApple> redApples = new ArrayList<>(2);
        redApples.add(new RedApple(1));
        redApples.add(new RedApple(2));
        ArrayListExample.deepCopy(redApples);
    }
}
