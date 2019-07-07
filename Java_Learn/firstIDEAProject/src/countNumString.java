import java.util.Scanner;

/**
 * @Classname counterNumString
 * @Description TODO
 * @Date 2019/7/3 18:33
 * @Created by AppleTree
 */
public class countNumString {

    public static final boolean judgeNum(char c){
        if(c >= 48 && c <= 57){
            return true;
        }else {
            return false;
        }
    }

    public static final String counterNum(String str) {
        if(str.length() > 255) {
            throw new UnsupportedOperationException("字符串长度越界");
        }

        StringBuffer temp = new StringBuffer();
        StringBuffer max = new StringBuffer();
        int i = 0;
        for (i = 0; i < str.length() - 1; i++) {//1223
            if(judgeNum(str.charAt(i)) && judgeNum(str.charAt(i+1))){
                temp.append(str.charAt(i));
            }else{
                temp.append(str.charAt(i));
                if(temp.length() > max.length()){
                    max.replace(0, temp.length(), temp.toString());
                    temp.delete(0,temp.length());
                }else {
                    temp.delete(0,temp.length());
                }
            }
        }
        if(max.length() == 0){
            temp.append(str.charAt(i));
            max.replace(0, temp.length(), temp.toString());
            return max.toString();
        }
        if(max.length() < temp.length()+1){
            temp.append(str.charAt(i));
            max.replace(0, temp.length(), temp.toString());
            return max.toString();
        }
        return max.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(counterNum(str));
    }

}
