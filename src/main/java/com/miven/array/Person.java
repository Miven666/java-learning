package com.miven.array;

/**
 * 人
 *
 * @author mingzhi.xie
 * @date 2019/4/22.
 */
public class Person {
    /**
     * 名字
     */
    private String name;

    void setName(String name) {
        this.name = name;
    }

    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
