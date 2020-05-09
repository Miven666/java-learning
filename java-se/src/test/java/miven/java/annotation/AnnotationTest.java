package miven.java.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;

public class AnnotationTest {

    @Test
    public void testInherited() {
        Annotation[] sonAnnotations = Son.class.getAnnotations();
        // 只查找被显示申明的注解
        Annotation[] declaredAnnotations = Son.class.getDeclaredAnnotations();
        Annotation[] daughterAnnotations = Daughter.class.getAnnotations();

        for (Annotation sonAnnotation : sonAnnotations) {
            System.out.println("Son annotation: " + sonAnnotation);
        }
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println("Son declared annotation: " + declaredAnnotation);
        }
        for (Annotation daughterAnnotation : daughterAnnotations) {
            System.out.println("Daughter annotation: " + daughterAnnotation);
        }
    }
}