package com.miven.classloader;

/**
 * 应用加载器
 * @author mingzhi.xie
 * @date 2018/12/17.
 */
public class App {

    /**
     * 查看加载的路径
     * @return
     */
    public String showClassPath() {
        return System.getProperty("java.class.path");
    }
}