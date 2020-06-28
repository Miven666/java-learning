package miven.java.annotation;

/**
 * @author mingzhi.xie
 * @date 2020/5/9
 * @since 1.0
 */
public class InheritedExample {

    @CustomExistInherited
    @CustomNoExistInherited
    public void noAnnotation() {
        System.out.println(InheritedExample.this.getClass().getName());
    }

}
