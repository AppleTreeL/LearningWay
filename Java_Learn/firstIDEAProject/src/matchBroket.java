import java.util.Stack;

/**
 * @Classname matchBroket
 * @Description TODO
 * @Date 2019/7/4 12:03
 * @Created by AppleTree
 */
public class matchBroket {

    public static final boolean judgeBroket(String A) {
        Stack<Character> stack = new Stack<>();
//        int countLeft = 0;
//        int countRight = 0;
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '('){
                stack.add(A.charAt(i));
                //countLeft += 1;
            }
            if(A.charAt(i) == ')'){
                if(!stack.empty())
                    stack.pop();
                else return false;
            }
        }
        if(stack.empty())
            return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeBroket("()()"));
    }

}
