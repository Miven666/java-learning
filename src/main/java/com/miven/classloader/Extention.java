package com.miven.classloader;

/**
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