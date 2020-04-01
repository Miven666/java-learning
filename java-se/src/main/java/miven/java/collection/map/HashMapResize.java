package miven.java.collection.map;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author mingzhi.xie
 * @date 2020/4/1
 * @since 1.0
 */
public class HashMapResize {
    static class Person {
        Integer id;
        String name;

        public Person(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return Objects.equals(id, person.id) && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>(4);
        // 初始化扩容
        map.put(new Person(0, "0"), "01");
        map.put(new Person(1, "1"), "02");
        map.put(new Person(1, "2"), "03");
        // 4 > 4 * 0.75f 会扩容
        map.put(new Person(1, "3"), "04");
        System.out.println(map.size());
    }
}
