package miven.java.string;

/**
 * {@link String} 示例
 *
 * @author mingzhi.xie
 * @since 2021/4/1 1.0.0
 */
public class StringDemo {

    public static void main(String[] args) {
        stringByteLength();
    }

    private static void stringByteLength() {
        System.out.println("测".getBytes().length);
        System.out.println("TB".getBytes().length);
        System.out.println("TB\nAA".replace("\n", ""));
    }
}
