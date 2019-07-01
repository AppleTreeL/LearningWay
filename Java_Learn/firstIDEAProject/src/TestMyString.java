import java.util.Scanner;
import java.util.UnknownFormatConversionException;

/**
 * @Classname TestMyString
 * @Description TODO
 * @Date 2019/6/30 22:09
 * @Created by AppleTree
 */
public class TestMyString {

    /**
     * 判断是否存在大写字符
     * @param str
     * @return 存在返回true, 不存在返回false
     */
    public static boolean judgeUpperChar(String str){
        for(int i = 0; i < str.length(); i++){
            if((str.charAt(i) >= 65 && str.charAt(i) <= 90)){
                return true;
            }
        }
        return false;
    }

    /**
     * 返回源字符串的逆序的字符串
     * @param str 原来的字符串
     * @return 逆序后的字符串
     */
    public static String reverse(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    /**
     * 计数成功构成回文串的情况数
     * @param A 被插入的串
     * @param B 用来插入的串
     * @return 成功构成回文串的情况数
     */
    public static int countHuiWen(String A, String B){
        if((A.length() >= 100 || B.length() >= 100)){
            throw new StringIndexOutOfBoundsException("字符串长度越界");
        }
        if(judgeUpperChar(A)) throw new UnknownFormatConversionException("不支持大写字母");
        if(judgeUpperChar(B)) throw new UnknownFormatConversionException("不支持大写字母");
        int count = 0;
        for(int i = 0; i < A.length(); i++ ){
            /*
             *将字符串A分成两半，然后与字符串B拼接，形成新字符串，然后回文判断
             */
            String a1 = A.substring(0,i);
            String a2 = A.substring(i);
            String aim = a1 + B + a2;

            if(aim.equals(reverse(aim))){
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        System.out.println(countHuiWen(A, B));
        System.out.println(' '==32);

//        String A = "abab";
//        String B = "*";
//        for(int i = 0; i < A.length() + 1; i++ ){
//            /*
//             *将字符串A分成两半，然后与字符串B拼接，形成新字符串，然后回文判断
//             */
//            String a1 = A.substring(0,i);
//            String a2 = A.substring(i);
//            String aim = a1 + B + a2;
//
//            System.out.println(aim);
//        }
    }
}
