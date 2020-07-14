package miven.java.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream Test
 * @author mingzhi.xie
 * @since 2020/7/14 1.0
 * @see Stream
 */
public class StreamTest {

    /**
     * 学习流的终端操作
     */
    @Test
    public void testTerminalOperation() {
        // '有返回值'的终端操作
        List<String> abc = Arrays.asList("A", "B", "C");
        List<String> abcNew = abc.stream().map(s -> {
            String lowerCase = s.toLowerCase();
            System.out.println(lowerCase);
            return lowerCase;
        }).collect(Collectors.toList());
        abcNew.forEach(System.out::println);

        // close 虽然是'无返回值'的终端操作，但它会使流直接关闭，从而使对流的修整操作失效
        List<String> def = Arrays.asList("D", "E", "F");
        def.stream().map(s -> {
            // 这里对流的修整操作并不会执行
            String lowerCase = s.toLowerCase();
            System.out.println(lowerCase);
            return lowerCase;
        }).close();

        // '无返回值'的终端操作且成功消费流应该用 forEach
        Stream.of("G", "H", "I").forEach(s -> {
            String lowerCase = s.toLowerCase();
            System.out.println(lowerCase);
        });
    }
}
