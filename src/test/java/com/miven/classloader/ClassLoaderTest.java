package com.miven.classloader;

import org.junit.Test;

/**
 * 类加载器 测试类
 */
public class ClassLoaderTest {

    /**
     * 测试顶级加载器 加载路径
     */
    @Test
    public void showBootStrapClassPathTest() {
        BootStrap bootStrap = new BootStrap();
        printlnPath(bootStrap.showClassPath());
    }

    /**
     * 测试扩展加载器 加载路径
     */
    @Test
    public void showExtentionClassPathTest() {
        Extention extention = new Extention();
        printlnPath(extention.showClassPath());
    }

    /**
     * 测试应用加载器 加载路径
     */
    @Test
    public void showAppClassPathTest() {
        APP app = new APP();
        printlnPath(app.showClassPath());
    }

    /**
     * 测试当前类加载器以及上层父级加载器
     */
    @Test
    public void showParentPathTest() {
        ClassLoader currentClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(currentClassLoader.toString());  // AppClassLoader
        System.out.println(currentClassLoader.getParent().toString());  // ExtClassLoader
        System.out.println(currentClassLoader.getParent().getParent().toString());  // null, 从源码ExtClassLoader类的无参构造可以看出
    }

    /**
     * 打印输出路径
     * @param path
     */
    public void printlnPath(String path) {
        String[] split = path.split(";");
        for (String s : split) {
            System.out.println(s);
        }
    }
}