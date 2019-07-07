import java.util.Stack;

/**
 * @Classname StackToSqune
 * @Description TODO
 * @Date 2019/7/6 15:29
 * @Created by AppleTree
 */
public class StackToSqune {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackToSqune stackToSqune = new StackToSqune();
        stackToSqune.push(1);
        stackToSqune.push(2);
        stackToSqune.push(3);
        stackToSqune.push(4);
        stackToSqune.push(5);
        System.out.println(stackToSqune.pop());
    }

}
