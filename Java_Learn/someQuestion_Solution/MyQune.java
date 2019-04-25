//import com.sun.javafx.animation.TickCalculation;

public class MyQune{
    
    class Node{
        private int data;
        private Node next;
        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int usedSize;
    public Node front;
    public Node rear;
    public MyQune(){
        this.front = null;
        this.rear = null;
        this.usedSize = 0;
    }

    public boolean isEmpty() {
        if(this.front == null && this.rear == null)
            return true;
        else 
            return false;
    }

    /**
     * insert a node to a qune
     * @param data
     */
    public void insertQune1(int data) {
        Node node = new Node(data);
        if(isEmpty()){
            this.front = node;
            this.rear = node;
            this.usedSize += 1;
        }else{
            this.rear.next = node;
            this.rear = node;
            this.usedSize += 1;
        }
    }

    public Node peek() {
        if(isEmpty())
            return null;
        return this.front;
    }

    /**
     * pop the rear
     * @return
     */
    public Node pop() {
        if(isEmpty())
            return null;
        else{
            Node oldFront = this.front;
            if(this.usedSize > 1) {
                //Node oldfront = this.front;
                this.front = this.front.next;
                this.usedSize -= 1;
                return oldFront;
            }else{
                //Node oldFront = this.front;
                this.front = this.front.next;
                this.rear = null;
                return oldFront;
            }
        }
    }



    public static void main(String[] args) {
        MyQune myQune = new MyQune();
        myQune.insertQune1(1);
        myQune.insertQune1(2);
        myQune.insertQune1(3);
        myQune.insertQune1(4);
        myQune.pop();
        System.out.println(myQune.front.data);
    }
}