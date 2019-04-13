## 浅谈工厂设计模式

____

### 1、简单工厂模式

+ 又名静态工厂方法，实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。

+ 一个简单实例：

  > ```java
  > interface Computer{//定义一个Computer接口
  >  void printComputer();
  > }
  > 
  > class MacbookProComputer implements Computer {//苹果电脑的实现Computer接口生产苹果电脑
  > 	public void printComputer() {
  > 		System.out.println("This is a MacbookPro");
  > 	}
  > }
  > 
  > 
  > class SurfaceBookComputer implements Computer {//微软系列电脑的实现Computer接口生产微软系列电脑
  > 	public void printComputer() {
  > 		System.out.println("This is a SurfaceBook");
  > 	}
  > }
  > 
  > 
  > class ComputerFactory {//模拟生产电脑的一个工厂
  > 	public static Computer getInstance(String type) {//生产电脑的方法，根据用户的选择来决定生产哪种类型的电脑
  > 		Computer computer = null;
  > 		if (type.equals("macbook")) {
  > 			computer = new MacbookProComputer();//生产苹果电脑
  > 		}else if (type.equals("surface")) {
  > 			computer = new SurfaceBookComputer();//生产微软电脑
  > 		}
  > 		return computer;
  > 	}
  > }
  > 
  > 
  > public class Client {//模拟客户端
  > 	public void buyComputer(Computer computer) {//模拟客户买电脑动作
  > 		computer.printComputer();
  > 	}
  > 	public static void main(String[] args) {
  > 		Client client = new Client();
  > 		Scanner scanner = new Scanner(System.in);
  > 		System.out.println("请输⼊您想要的电脑型号...");
  > 		String type = scanner.nextLine();
  > 		Computer computer = ComputerFactory.getInstance(type);//根据用户的选择来决定生产哪种类型的电脑
  > 		 client.buyComputer(computer);//用户购买
  > 	}
  > }
  > ```
  >
  > Tips:
  >
  > ​	1.优点：易于实现，各模块间耦合度小。
  >
  > ​	2.缺点：违反OCP开放封闭原则，因为添加具体产品需要修改⼯⼚。

  ------

  

### 2、工厂方法模式

+ 核心是封装类中变化的部分，提取其中个性化善变的部分为独立类，通过依赖注入以达到解耦、复用和方便后期维护拓展的目的。

+ ⼯⼚⽅法模式是针对每个产品提供⼀个⼯⼚类，在客户端中判断使⽤哪个⼯⼚类去创建对象。

+ 将上例的 ComputerFactory类 抽象成⼀个接⼝，那么创建相应具体的⼯⼚类去实现该接⼝的⽅法

  > ```java
  > interface Computer{//定义一个Computer接口
  >  void printComputer();
  > }
  > 
  > class MacbookProComputer implements Computer {//苹果电脑的实现Computer接口生产苹果电脑
  > 	public void printComputer() {
  > 		System.out.println("This is a MacbookPro");
  > 	}
  > }
  > 
  > 
  > class SurfaceBookComputer implements Computer {//微软系列电脑的实现Computer接口生产微软系列电脑
  > 	public void printComputer() {
  > 		System.out.println("This is a SurfaceBook");
  > 	}
  > }
  > 
  > /**
  > *将ComputerFactory类抽象成一个工厂接口，有具体的电脑种类去实现
  > */
  > interface ComputerFactory {//模拟生产电脑的一个工厂
  > 	void creatcomputer();
  > }
  > 
  > class MsFactory implements ComputerFactory {//微软电脑工厂
  > 	public Computer createComputer() {//生产微软电脑
  > 		return new SurfaceBookComputer();
  > 	}
  > }
  > 
  > class AppleFactory implements ComputerFactory {//苹果电脑工厂
  > 	public Computer createComputer() {//生产苹果电脑
  > 		return new MacbookProComputer();
  > }
  > }
  > 
  > 
  > public class Client {//模拟客户端
  > 	public void buyComputer(Computer computer) {//模拟客户买电脑动作
  > 		computer.printComputer();
  > 	}
  > 	public static void main(String[] args) {
  > 		Client client = new Client();
  > 		ComputerFactory factory = new AppleFactory();//实例化一个苹果电脑
  > 		client.buyComputer(factory.createComputer());//用户购买这个苹果电脑
  > 	}
  > }
  > ```
  >
  > Tips：
  >
  > ​	1.工厂方法模式符合开闭原则，但是增加了客户端的开销，在客户端界定生产具体的型号电脑。
  >
  > ​	2.有利于业务扩展，因为如果要增加一个新的电脑类型，只需要实现创建具体电脑类，再实现该型号的具体工厂类即可。例如要新增一个华硕电脑类及其工厂：
  >
  > ```java
  > .....
  >  class ASUSComputer implements Computer{
  >      public void printComputer(){
  >          System.out.println("This is a ASUSPro");
  >      }
  >  }
  > .....
  >  class AUSUFactory implements ComputerFactory{
  >      public Computer createComputer() {//生产华硕电脑
  > 			return new SurfaceBookComputer();
  > 		}
  >  }
  > ```

  ___

  

### 3、抽象工厂模式

+ ⼯⼚⽅法模式和抽象⼯⼚模式基本类似，当⼯⼚只⽣产⼀个产品的时候，即为⼯⼚⽅法
  模式，⽽⼯⼚如果⽣产两个或以上的商品即变为抽象⼯⼚模式。

+ 修改上面的例子：

  > ```java
  > interface Computer {//定义一个Computer接口
  > 	void printComputer();
  > }
  > 
  > class MacbookProComputer implements Computer {//苹果电脑的实现Computer接口生产苹果电脑
  > 	public void printComputer() {
  > 		System.out.println("This is a MacbookPro");
  > 	}
  > }
  > 
  > class SurfaceBookComputer implements Computer {//微软电脑的实现Computer接口生产微软电脑
  > 	public void printComputer() {
  > 		System.out.println("This is a SurfaceBook");
  > 	}
  > }
  > 
  > /**
  > *新定义一个操作系统接口
  > */
  > interface OperatingSystem {
  > 	void printSystem();
  > }
  > 
  > class MacOsSystem implements OperatingSystem {//实现Mac操作系统
  > 	public void printSystem() {
  > 		System.out.println("This is a mac os");
  > 	}
  > }
  > 
  > class Windows8System implements OperatingSystem {//实现Windows操作系统
  > 	public void printSystem() {
  > 		System.out.println("This is a window 8");
  > 	}
  > }
  > 
  > /**
  > *新的工厂接口
  > */
  > interface ProductionFactory {
  > 	Computer createComputer();//生产电脑
  > 	OperatingSystem createSystem();//发行操作系统
  > }
  > 
  > class AppleFactory implements ProductionFactory {//新的苹果电脑工厂，他附加了适配Macc操作系统功能
  > 	public Computer createComputer() {
  > 		return new MacbookProComputer();
  > 	}
  > 	public OperatingSystem createSystem() {//发行Mac操作系统
  > 		return new MacOsSystem();
  > 	}
  > }
  > 
  > class MsFactory implements ProductionFactory {//新的微软电脑工厂，他附加了适配Windows操作系统功能
  > 	public Computer createComputer() {
  > 		return new SurfaceBookComputer();
  > 	}
  > 	public OperatingSystem createSystem() {//发行Windows操作系统
  > 		return new Windows8System();
  > 	}
  > }
  > 
  > 
  > public class Client {
  > 	public void buyComputer(Computer computer) {
  > 		computer.printComputer();
  > 	}
  > 	public void use(OperatingSystem s) {
  > 		s.printSystem();
  > 	}
  > 	public static void main(String[] args) {
  > 		Client client = new Client();
  > 		ProductionFactory factory = new AppleFactory();//工厂生产一个苹果电脑
  > 		Computer computer = factory.createComputer();
  > 		OperatingSystem system = factory.createSystem();//发行一个Mac系统
  > 		client.buyComputer(computer);//客户拿到苹果电脑
  > 		client.use(system);//这个电脑使用Mac操作系统
  > 	}
  > }
  > ```
  >
  > Tips：
  >
  > ​	1.低耦合。
  >
  > ​	2.实现多个产品的生产。
  >
  > ​	3.满足OCP开放原则。
  >
  > ​	4.易于复杂对象的生产。
  >
  > ​	5.扩展不易。

  ___

  

  

