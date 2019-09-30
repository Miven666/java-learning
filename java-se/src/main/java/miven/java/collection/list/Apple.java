package miven.java.collection.list;

import java.util.Objects;

/**
 * 水果
 *
 * @author mingzhi.xie
 * @date 2019/4/22.
 */
public class Apple implements Call {

    int id;

    String name;

    Apple() {
        this.name = "I'm name is Apple";
    }

    Apple(int id) {
        this.id = id;
        this.name = "I'm name is Apple";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Apple apple = (Apple) o;
        return id == apple.id &&
                Objects.equals(name, apple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String call() {
        return name;
    }

}
