package NewCoderTest;

import java.util.Scanner;


/**
 * @Classname findNum1
 * @Description TODO
 * @Date 2019/5/27 19:11
 * @Created by AppleTree
 */
public class findNum1 {

    /**
     * 计数0到max各个数中有多少个1
     * @param max
     * @return
     */
    public static final int countSumOne(int max){
        int sumOne = 0;

        if(max < 0 || max > 2147483647)
            throw new IllegalArgumentException("数据越界");

        long start = 0;
        long end = 0;
        for(int i = 0; i <= max; i ++)
        {
            start = System.currentTimeMillis();
            sumOne += countOne(i);
            end = System.currentTimeMillis();
            System.out.println(end - start);
        }

        return sumOne;
    }


    public static final int countOne(int num){
        int count = 0;


        String strNUm = String.valueOf(num);
        char[] strCahr = strNUm.toCharArray();
        for (int i = 0; i < strCahr.length; i++) {
            if(strCahr[i] == '1'){
                count += 1;
            }
        }


        return count;
    }


    public static String stringCompress(String str){//字符串压缩函数
        int pos = 0;	//记录比较的位置
        int count = 1;	//计数相同字符的数量
        char[] chs = str.toCharArray();	//将传入的字符串转换成字符数组
        char temp;	//记录当前正在做计数工作的字符
        StringBuffer sb = new StringBuffer();	//存放压缩后的字符串的StringBuffer，
        // 这里我们需要使用appened()方法来逐步追加来完成压缩后的字符串的构建，所以使用了StringBUffer
        for(int i= 0; i <= chs.length-1; i = pos + 1){
            temp = chs[i];
            pos = i;
            while(pos < chs.length-1 && chs[pos] == chs[pos+1]){//遍历字符数组，直到结束或者遇到不同的
                count++;
                pos++;
            }
            //if(count > 1){	//计数结果两个以上追加数字
                sb.append(temp);
                sb.append(count);
//            }else{	//计数结果为1不追加数字
//                sb.append(temp);
//            }
            count = 0;
        }
        return sb.toString();	//将StringBUffer转换成字符串返回
    }

    public static void main(String[] args) {
        //long start = System.currentTimeMillis();
//        Scanner in = new Scanner(System.in);
//        int value  = in.nextInt();
//        System.out.println(countSumOne(2147483647));
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);

//        Scanner in = new Scanner(System.in);
//        String value  = in.next();
        System.out.println(stringCompress("appendxx"));

    }

}
