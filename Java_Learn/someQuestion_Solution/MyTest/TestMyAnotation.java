package MyTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Classname TestMyAnotation
 * @Description TODO
 * @Date 2019/5/22 17:20
 * @Created by AppleTree
 */

@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface TestMyAnotation {
    public Class<?> targetClass();
}
