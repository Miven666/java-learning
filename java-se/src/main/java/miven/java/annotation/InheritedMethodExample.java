package miven.java.annotation;

/**
 * @author mingzhi.xie
 * @date 2020/5/9
 * @since 1.0
 */
public class InheritedMethodExample extends InheritedExample {

    @Override
    public void noAnnotation() {
        System.out.println(this.getClass().getName());
    }
}
