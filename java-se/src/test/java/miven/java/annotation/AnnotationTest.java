package miven.java.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {

    @Test
    public void testInherited() throws NoSuchMethodException {
        Annotation[] sonAnnotations = Son.class.getAnnotations();
        for (Annotation sonAnnotation : sonAnnotations) {
            System.out.println("Son annotation: " + sonAnnotation);
        }

        // 只查找被显示申明的注解
        Annotation[] declaredAnnotations = Son.class.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println("Son declared annotation: " + declaredAnnotation);
        }

        Method method = InheritedMethodExample.class.getMethod("noAnnotation");
        Annotation[] declaredExamples = method.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredExamples) {
            System.out.println("Example declared annotation: " + declaredAnnotation);
        }
        Annotation[] examples = method.getAnnotations();
        for (Annotation example : examples) {
            System.out.println("Example annotation: " + example);
        }

        Annotation[] daughterAnnotations = Daughter.class.getAnnotations();
        for (Annotation daughterAnnotation : daughterAnnotations) {
            System.out.println("Daughter annotation: " + daughterAnnotation);
        }
    }
}