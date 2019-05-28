package MyTest;

//题目描述：通过反射赋值源对象中的属性值到目标对象的具有相同类型和名称的属性

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @Classname BeanUtils
 * @Description TODO
 * @Date 2019/5/20 20:41
 * @Created by AppleTree
 */
public class BeanUtils {
    /**
     * 对象的属性值拷贝
     * <p>
     * 将source对象中的属性值赋值到target对象中的属性，属性名一样，类型一样
     * <p>
     * example:
     * <p>
     * source:
     * <p>
     * String name;
     * String address;
     * Integer age;
     * Date   birthday;
     * <p>
     * target:
     * String name;
     * String address;
     * String email
     * <p>
     * 结果： source name, address -> target name, address
     *
     * @param source
     * @param target
     */
    public static void copy(Object source, Object target) throws IllegalAccessException {
        //TODO

        if(source == null) throw new IllegalArgumentException("source should not be null");
        if(target == null) throw  new IllegalArgumentException("target should not be null");

        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Field[] sourceFields = sourceClass.getFields();
        Field[] targetFields = targetClass.getFields();

        //System.out.println("Source length is" + sourceFields.length);

//        for(int i = 0; i < sourceFields.length; i ++){
//            sourceFields[i].setAccessible(true);
//        }
//        for(int i = 0; i < targetFields.length; i ++){
//            targetFields[i].setAccessible(true);
//        }

//        System.out.println("Source length is" + sourceFields.length);
//        System.out.println("===============");
//        for (Field field: sourceFields) {
//            System.out.println(field.get(source));
//        }

        for(int i = 0; i < sourceFields.length; i ++){
            for (int j = 0; j < targetFields.length; j++) {
                if(sourceFields[i].getName().equals(targetFields[j].getName())
                        && sourceFields[i].getType().equals(targetFields[j].getType()) ){
                    Object sourceField = sourceFields[i].get(source);
                    System.out.println("run");
                    targetFields[j].set(target,sourceField);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Date sourceBirth = new Date(2019,5,20);
        Source source = new Source("Calvin", "China", 89, sourceBirth);
        Target target = new Target();
        BeanUtils.copy(source, target);
        System.out.println(target);

    }

}

class Source{
//    private String name;
//    private String address;
//    private Integer age;
//    private Date birthday;
    public String name;
    public String address;
    public Integer age;
    public Date birthday;

    public Source(String name, String address, Integer age, Date birthday) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}

class Target{
    public String name;
    public String address;
    public String email;

    public Target(){}

    public Target(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Target{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
