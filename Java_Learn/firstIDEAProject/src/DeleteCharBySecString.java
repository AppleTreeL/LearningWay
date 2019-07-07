import java.util.Scanner;

/**
 * @Classname DeleteCharBySecString
 * @Description TODO
 * @Date 2019/7/6 14:08
 * @Created by AppleTree
 */
public class DeleteCharBySecString {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(deleteBySecondString(s1, s2));
    }

    public static final String deleteBychar(String s1, char c){
        StringBuilder stringBuilder = new StringBuilder();
        char[] cs1 = s1.toCharArray();

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == c){
                cs1[i] = ' ';
            }
        }

        for (int i = 0; i < cs1.length; i++) {
            if(cs1[i] != ' '){
                stringBuilder.append(cs1[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static final String deleteBySecondString(String s1, String s2){
        String[] strings = s1.split(" ");
        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < strings.length; j++) {
                strings[j] = deleteBychar(strings[j], s2.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
            if((i + 1) < strings.length)
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
