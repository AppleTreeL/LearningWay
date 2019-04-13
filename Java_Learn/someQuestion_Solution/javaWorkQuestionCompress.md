### 一道面试题字符串转化（压缩）   “aabbccdaa” -> "a2b2c2d1a2"

大佬的原文:https://blog.csdn.net/lds_lsj/article/details/48752299



____

#### 1、解决方案

这里如果我们想在原字符串上直接替换，我们可以预想到对一个时刻在变的字符串的操作的情况，非常复杂。

那么我们采取新建一个变量以填充的方式构建这样的一个压缩字符串，这样就方便很多。

____

#### 2、具体实现

```java
public static String stringCompress(String str){//字符串压缩函数
        int pos = 0;	//记录比较的位置
    	int count = 1;	//计数相同字符的数量
        char[] chs = str.toCharArray();	//将传入的字符串转换成字符数组
        char temp;	//记录当前正在做计数工作的字符
        StringBuffer sb = new StringBuffer();	//存放压缩后的字符串的StringBuffer，这里我们需要使用appened()方法来逐步追加来完成压缩后的字符串的构建，所以使用了StringBUffer
        for(int i= 0; i <= chs.length-1; i = pos + 1){
            temp = chs[i];
            pos = i;
            while(pos < chs.length-1 && chs[pos] == chs[pos+1]){//遍历字符数组，直到结束或者遇到不同的
                count++;
                pos++;
            }
            if(count > 1){	//计数结果两个以上追加数字
                sb.append(temp);
                sb.append(count);
            }else{	//计数结果为1不追加数字
                sb.append(temp);
            }
        }
        return sb.toString();	//将StringBUffer转换成字符串返回
    }
```

___

