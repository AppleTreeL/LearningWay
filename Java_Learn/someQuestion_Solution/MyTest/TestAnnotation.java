package MyTest;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Classname TestAnnotation
 * @Description TODO
 * @Date 2019/5/22 17:23
 * @Created by AppleTree
 */

@Retention(RetentionPolicy.RUNTIME)
@interface Myannotation{
    public String name() default "messi";
    public int age() default 28;
}


@Deprecated
@Myannotation
class Member implements Serializable{

}

public class TestAnnotation {
    public static void main(String[] args) {
        Annotation annotation = Member.class.getAnnotation(Myannotation.class);
        System.out.println(((Myannotation) annotation).age());
        System.out.println(((Myannotation) annotation).name());
//        Annotation[] annotations = Member.class.getAnnotations();
//        for(Annotation a: annotations) {
//            System.out.println(a);
//        }
    }
}
