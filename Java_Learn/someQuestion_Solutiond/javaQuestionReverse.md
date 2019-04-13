### 一道面试题：i am biter 逆置为：biter am  i

### 1、解决思路

首先我们明确一点，这是<font color = aqua>每个单词的整体倒置</font>；

明确了这一点，我们可以在遍历字串时，先设计一个StringBuffer来暂存遇到空格之前的字符，每遇到空格就利用insert()方法让其插入到另一个StringBuffer的0号位置，并追加一个空格添加到末尾，以达到单词整体逆置并分开的效果。

____

### 3、方法实现

```java
public static String reverseSentence(String str) {	//整体逆置方法
        char[] chr = str.toCharArray();
        int pos = 0;
        StringBuffer temp = new StringBuffer();	//暂存空格前一系列字符
        StringBuffer sb = new StringBuffer();	//存放逆置结果
        for (int i = 0; i < chr.length; i++) {
            if(chr[i] != 32){	//如果不是空格
                temp.append(chr[i]);
            }else {
                sb.insert(0,temp.toString()+" ");
                temp.replace(0,temp.length(),"");	//清空暂存字符串的StringBuffer temp
            }
        }
        sb.insert(0,temp.toString()+" "); //插入原文最后一个单词，因为最后一个单词后没有空格，但是已经暂存在temp，所以在这里额外插入
        return sb.toString();
    }
```

_____

### 4、测试

```java
....
public static void main(String[] args) {
        String str = "i am biter";
        System.out.println(Work_2019_2_12.reverseSentence(str));
    }
.....
```



