/**
 * @Classname MinStack
 * @Description TODO
 * @Date 2019/4/26 19:29
 * @Created by AppleTree
 */
public class MinStack {
    public MyStackImpl myStackData;
    public MyStackImpl minStack;
    /** initialize your data structure here. */
    public MinStack() {
        myStackData = new MyStackImpl(10);
        minStack = new MyStackImpl(10);
    }

    public void push(int x) {
        if(myStackData.empty() && minStack.empty()) {
            myStackData.push(x);
            minStack.push(x);
        }else {
            if(minStack.peek() > x){
                minStack.push(x);
                myStackData.push(x);
            }else{
                myStackData.push(x);
            }
        }
    }

    public void pop() {
        if(myStackData.peek() == minStack.peek()) {
            myStackData.pop();
            minStack.pop();
        }else{
            myStackData.pop();
        }
    }

    public int top() {
        return myStackData.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
