package miven.java.string;

import java.util.Arrays;

/**
 * {@link String} 示例
 *
 * @author mingzhi.xie
 * @since 2021/4/1 1.0.0
 */
public class StringDemo {

    public static void main(String[] args) {
        printByteLength();
        printHashCode();
        printHashCode();
    }

    private static void printByteLength() {
        System.out.println("测".getBytes().length);
        System.out.println("TB".getBytes().length);
        System.out.println("TB\nAA".replace("\n", ""));
        System.out.println(Arrays.toString("|test".split("\\|")));
    }

    private static void printHashCode() {
        System.out.println("test#demo".hashCode());
    }
}
