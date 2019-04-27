package com.miven.classloader;

/**
 * 应用加载器
 * @author mingzhi.xie
 * @date 2018/12/17.
 */
class App {

    /**
     * 查看加载的路径
     * @return 路径
     */
    String showClassPath() {
        return System.getProperty("java.class.path");
    }
}