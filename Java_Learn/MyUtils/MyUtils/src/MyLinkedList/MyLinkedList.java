package MyLinkedList;

/**
 * @Classname MyLinkedList
 * @Description TODO
 * @Date 2019/6/2 14:00
 * @Created by AppleTree
 */
public class MyLinkedList<E> {
    class Node <T>{
        public T data;
        public Node next;

        public Node (T data){
            this.data = data;
            this.next = null;
        }
    }

    public Node<E> head;
    public Node<E> last;
    public int size;

    public MyLinkedList(){
        this.head = null;
        this.last = null;
        this.size = 0;
    }


    public boolean isEmpty(){
        return this.size == 0;
    }

    public void addLast(E data){
        Node<E> node = new Node<>(data);
        if(isEmpty()){
            this.head = node;
            this.last = node;
            this.size += 1;
        }else{
            this.last.next = node;
            this.last = this.last.next;
            this.size += 1;
        }
    }
}
