package miven.java.annotation;

import java.lang.annotation.*;

/**
 * 自定义能被继承注解
 * @author mingzhi.xie
 * @date 2019/9/11
 * @since 1.0
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface CustomExistInherited {
}
