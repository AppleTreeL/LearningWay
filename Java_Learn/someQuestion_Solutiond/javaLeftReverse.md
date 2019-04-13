### 将一个数组从左开始第几位之前的进行旋转：左旋数组，如：将"abcdef"第2位之前(a为0号位置)进行旋转----》"cdefab"

_____



+ 解决思路：

  将第n位之前需要变换的那部分字符串存入一个StringBuffer里，然后进行变换，最后与余下的不变的部分拼接，返回结果。

  _____

  

+ 方法实现：

  ```java
  public static String leftRotateString(String str,int n){
          StringBuffer change = new StringBuffer();
          change = new StringBuffer(str.substring(0, n));//截取需要变换的部分
          change.reverse();
          String re = change.toString() + str.substring(n,str.length());//与余下的不变换的部分拼接
          return  re;
      }
  ```

  ____

  

+ 测试：

  ```java
  ...
  public static void main(String[] args) {
      String str = "abcdef";
      System.out.println(Work_2019_2_12.leftRotateString(str, 2));
  }
   ...
  ```

  ____

  