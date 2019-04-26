/**
 * @Classname StackToQune
 * @Description 栈实现队列
 * @Date 2019/4/26 19:08
 * @Created by AppleTree
 */
public class StackToQune {
    public MyStackImpl myStack1;
    public MyStackImpl myStack2;
    /** Initialize your data structure here. */
    public StackToQune() {
        myStack1 = new MyStackImpl(10);
        myStack2 = new MyStackImpl(10);
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        myStack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(myStack2.empty()){
            while ( !myStack1.empty()) {
                myStack2.push(myStack1.pop());
            }
        }
        return myStack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(myStack2.empty()){
            while ( !myStack1.empty()) {
                myStack2.push(myStack1.pop());
            }
        }
        return myStack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(myStack2.empty() && myStack1.empty()) return true;
        else return false;
    }
}
