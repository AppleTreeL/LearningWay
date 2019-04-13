###  统计字符串中数字个数  , 如："abc21b416u" ===>  输出5

+ 可以采用直接判断的方式如：

  ```java
  if(((chs[i] <= 'z') && (chs[i] >= 'a'))  ||  ((chs[i] <= 'Z') && (chs[i] >= 'A')))
  ```

  ___

  

+ 也可以采用比较ASCII码的方式:

  ```java
  if(((chs[i] <= 122) && (chs[i] >= 97))  ||  ((chs[i] <= 90) && (chs[i] >= 65)))
  ```

  ___

  

+ 笔者采用直接判断，完整实现如下:

  ```java
  public static int isNumeric(String str){
          int count  = 0;	//计数字母个数
          char[] chs = str.toCharArray();
          for (int i = 0; i <= chs.length - 1; i++) {
              if(((chs[i] <= 'z') && (chs[i] >= 'a'))  ||  ((chs[i] <= 'Z') && (chs[i] >= 'A'))){
                  count += 1;
              }
          }
          return  count;
      }
  ```

  ____

  