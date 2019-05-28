package MyTest;

import java.lang.annotation.Annotation;

/**
 * @Classname AnnotationFactory
 * @Description TODO
 * @Date 2019/5/22 17:48
 * @Created by AppleTree
 */

interface Fruit{
    public void eat();
}

class Apple implements Fruit{
    @Override
    public void eat() {
        System.out.println("I am eating Apple");
    }
}

@TestMyAnotation(targetClass = Apple.class)
class Factory{

    public static <T> T getInstance() throws IllegalAccessException, InstantiationException {
        TestMyAnotation tar = Factory.class.getAnnotation(TestMyAnotation.class);
        return (T) tar.targetClass().newInstance();
    }

}


public class AnnotationFactory {
    public static void main(String[] args) {
        Fruit fruit = null;
        try {
            fruit = Factory.getInstance();
            fruit.eat();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
