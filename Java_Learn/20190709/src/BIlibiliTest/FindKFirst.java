package BIlibiliTest;



import java.util.Scanner;

/**
 * @Classname FindKFirst
 * @Description TODO
 * @Date 2019/7/22 22:25
 * @Created by AppleTree
 */
public class FindKFirst {

    public static void deleteALLStringBuilder(StringBuilder stringBuilder, char aim){
        int tempLength = stringBuilder.length();
        int i = 0;
        for (i = 0; i < tempLength;) {
            if(stringBuilder.charAt(i) == aim){
                stringBuilder.deleteCharAt(i);
                tempLength = tempLength - 1;
                i = 0;
            }else i += 1;
        }
    }

    public static char NChar(String str, int n){
        StringBuilder oneTimesChar = new StringBuilder(str);
        oneTimesChar.deleteCharAt(0);
        for (int i = 0; i < str.length(); i++) {
            //char res = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j) && i != j){
                    deleteALLStringBuilder(oneTimesChar, str.charAt(i));
                    break;
                }
            }
        }
        if(oneTimesChar.length() == 0){
            return 0;
        }else {
            return oneTimesChar.toString().charAt(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.nextLine();
        char res = NChar(str, n);
        if(res == 0){
            System.out.println("Myon~");
        }else{
            System.out.println("["+res+"]");
        }

//        StringBuilder test = new StringBuilder("asdasd");
//        System.out.println(test);
//        deleteALLStringBuilder(test, 'a');
//        deleteALLStringBuilder(test, 's');
//        deleteALLStringBuilder(test, 'd');
//        System.out.println(test.toString());
    }

}
