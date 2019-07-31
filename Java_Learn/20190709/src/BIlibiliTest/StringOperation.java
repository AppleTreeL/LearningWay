package BIlibiliTest;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname StringOperation
 * @Description TODO
 * @Date 2019/7/23 12:04
 * @Created by AppleTree
 */
public class StringOperation {

    public static StringBuffer toPostFix(String inFix) {
        Stack<String> stack = new Stack<>();
        StringBuffer postFix = new StringBuffer(inFix.length() * 2);
        int i = 0;
        while (i < inFix.length()) {
            char ch = inFix.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    while (!stack.empty() && !stack.peek().equals("(")) {
                        postFix.append(stack.pop());
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                case '*':
                case '/':
                    while (!stack.empty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        postFix.append(stack.pop());
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                case '(':
                    stack.push(ch + "");
                    i++;
                    break;
                case ')':
                    String out = stack.pop();
                    while (out != null && !out.equals('(')) {
                        postFix.append(out);
                        out = stack.pop();
                    }
                    i++;
                    break;
                default:
                    while (i < inFix.length() && ch >= '0' && ch <= '9') {
                        postFix.append(ch);
                        i++;
                        if (i < inFix.length()) {
                            ch = inFix.charAt(i);
                        }
                    }
                    postFix.append(" ");
            }
        }
        while (!stack.empty()) {
            postFix.append(stack.pop());
        }
        return postFix;
    }

    public static int toValue(StringBuffer postFix) {
        Stack<Integer> stack = new Stack<>();
        int value = 0;
        for (int i = 0; i < postFix.length(); i++) {
            char ch = postFix.charAt(i);
            if (ch <= '9' && ch >= '0') {
                value = 0;
                while (ch != ' ') {
                    value = value * 10 + ch - 48;
                    ch = postFix.charAt(++i);
                }
                stack.push(value);
            } else if (ch != ' ') {
                int y = stack.pop();
                int x = stack.pop();
                switch (ch) {
                    case '+':
                        value = x + y;
                        break;
                    case '-':
                        value = x - y;
                        break;
                    case '*':
                        value = x * y;
                        break;
                    case '/':
                        value = x / y;
                        break;
                }
                System.out.println(x + (ch + "") + y + "=" + value + ",");
                stack.push(value);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String resource = null;
        while (!(resource = in.nextLine()).equals("END")){
            StringBuffer temp = toPostFix(resource);
            System.out.println(toValue(temp));
            //resource = in.nextLine();
        }
    }

}

//    public static void main(String[] args) throws IOException, ScriptException {
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        String line;
//
//        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
//
//        while(!(line = in.readLine()).equals("END")) {
//
//            System.out.println(String.valueOf(scriptEngine.eval(line)));
//
//        }
//
//        in.close();
//
//    }
//}
