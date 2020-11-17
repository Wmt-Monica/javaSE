package reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)  //用于反射的注解需要设定为RUNTIME
public @interface annotationTest {
    String name() default "wmt";
    String type() default "true";
    int age() default 19;
}
