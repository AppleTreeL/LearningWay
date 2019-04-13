## Java抽象类与接口

___



### 1、抽象类

+ 抽象类是abstract修饰的类，不能生成对象，抽象类一般含有抽象方法，它的意义在于继承，它的定义格式为；

  ```java
  abstract class 类名称 [extends 父类名称] [implements 接口名称列表] {
      成员变量定义以及初始化；
      成员方法的定义以及初始化；
  }
  ```

+ 需要注意：

  1.抽象类可以没有抽象方法，但<font color = red>抽象方法必须定义在抽象类中</font>。

  2.抽象类一般含有抽象方法，需要子类继承。一个抽象类的子类，如果不是抽象类，则<font color = red>必须重写父类的所有抽象方法</font>,否则，该子类只能是抽象类。

  3.一个抽象类可以含有非抽象方法和成员变量，以及构造函数，可以让子类初始化父类的成员变量。

  4.抽象类<font color = red>不能定义为private、final、static类型</font>，因为抽象类本就是让别人继承的。

  5.构造方法不存在抽象类型。

  ___

  

### 2、抽象方法

+ 抽象方法是abstract修饰的方法，只有返回值类型，方法名，方法参数而不定义方法体的一种方法。格式为：

  ```java
  abstract 返回类型 方法名 (形参表);
  ```

+ 一个例子：

  ```java
    abstract class Shape{//定义抽象类Shape
        abstract void display();//抽象方法display
    }
    
    class Circle extends Shape{
        void display() {//重写实现抽象类Shape的抽象方法display
            System.out.println("Circle");
        }
    }
    
    class Rectangle extends Shape{
        void display() {//重写实现抽象类Shape的抽象方法display
            System.out.println("Rectangle");
        }
    }
    
    public class Test {
        public static void main(String[] args){
            (new Circle()).display();//创建Circle对象并执行重写实现的方法
            (new Rectangle()).display();//创建Rectangle对象并执行重写实现的方法
        }
    }
  ```

___

### 3、接口

+ 接口中只能包含<font color = dodgerblue>有名常量和没有实现的抽象方法</font>，而不能有变量、初始化块、构造方法和方法的实现。一般的定义形式如下：

  ```java
  public interface 接口名 [extends 直接父接口名列表] {
      [public static final] 类型 有名常量 = 常来值;
      [public abstract] 返回值类型 方法名(参数列表);
  }//方括号表示可以不写；
  ```

+ 需要注意：

  1. 接口定义的<font color = dodgerblue>所有常量具有public、static和final属性</font>。这些修饰符可以写出也可以不写，即表示默认具有public static final属性，并且在定义有名常量时必须包含初始化表达式（接口中没有静态初始化快）。

  2. 接口中<font color = dodgerblue>所有的方法具有public abstract 属性</font>。可不写，表示默认具有该属性。

  3. 接口不能实例化。

  4. 一个抽象类继承接口，那么<font color = red>抽象类中可以不实现</font>其中的方法。但是再有一个普通类继承此抽象类，那么这个普通类一定要实现接口和抽象类的抽象方法

  5. 接口和抽象类的区别：

     | 区别点     | 抽象类                      | 接口                                                |
     | ---------- | --------------------------- | --------------------------------------------------- |
     | 结构组成   | 普通类+抽象方法             | 抽象方法+全局常量                                   |
     | 权限       | 各种权限                    | public                                              |
     | 子类的使用 | 使用extends关键字继承抽象类 | 使用implements关键字实现接口                        |
     | 关系       | 一个抽象类可以继承若干接口  | 不可以继承抽象类，但可使用extends关键字继承多个接口 |
     | 子类的限制 | 一个子类只能继承一个抽象类  | 一个子类可以实现多个接口                            |

  6. 一个例子：

     ```java
     /**
     *定义计算图形面积和周长的功能接口
     */
     interface IShape{
         double PI = 3.1415926;//等价于 public static final double PI = 3.1415926;
         abstract double getArea();
         abstract double getPerimeter();
     }
     ```

     ___

     

