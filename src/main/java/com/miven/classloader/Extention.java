package com.miven.classloader;

/**
 * 扩展加载器
 * @author mingzhi.xie
 * @date 2018/12/17.
 */
public class Extention {

    /**
     * 查看加载的路径
     * @return
     */
    public String showClassPath() {
        return System.getProperty("java.ext.dirs");
    }
}