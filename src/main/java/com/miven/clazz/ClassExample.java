package com.miven.clazz;

/**
 * Class样品
 *
 * @author mingzhi.xie
 * @date 2019/4/16.
 */
class ClassExample {

    private Class clazz = ClassExample.class;

    /**
     * 获取类名（含包路径）
     * @return 类名+包路径
     */
    String getNameMethod() {
        return this.clazz.getName();
    }

    String getSimpleNameMethod() {
        return this.clazz.getSimpleName();
    }
}
