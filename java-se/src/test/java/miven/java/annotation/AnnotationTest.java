package miven.java.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;

public class AnnotationTest {

    @Test
    public void testInherited() {
        Annotation[] sonAnnotations = Son.class.getAnnotations();
        Annotation[] daughterAnnotations = Daughter.class.getAnnotations();

        for (Annotation sonAnnotation : sonAnnotations) {
            System.out.println("Son annotation: " + sonAnnotation);
        }

        for (Annotation daughterAnnotation : daughterAnnotations) {
            System.out.println("Daughter annotation: " + daughterAnnotation);
        }
    }
}