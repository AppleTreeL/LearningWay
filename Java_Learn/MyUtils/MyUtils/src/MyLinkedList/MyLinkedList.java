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


    /**
     * add the data to the end of List
     * @param data
     */
    public void addLast (E data){
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


    /**
     * remove the last node of your list
     * if the size is one , make the list empty
     */
    public void removeLast(){
        if(isEmpty())
            throw new UnsupportedOperationException("your list is empty, the length is :" + this.size);
        if(this.head != this.last) {
            Node<E> cur = this.head;
            while (cur.next != this.last) {
                cur = cur.next;
            }
            this.last = cur;
            this.last.next = null;
        }else {
            this.head = this.last = null;
        }
    }


    /**
     * add the data to the start of your list
     * @param data
     */
    public void addFirst(E data) {
        Node<E> node = new Node<>(data);
        if(isEmpty()) {
            this.head = node;
            this.last = node;
            this.size += 1;
        }else {
            Node<E> temp = this.head;
            this.head = node;
            node.next = temp;
            this.size += 1;
        }
    }


    /**
     * remove the First node of your list
     * if the size is one , make the list empty
     */
    public void removeFirst(){
        if(isEmpty())
            throw new UnsupportedOperationException("your list is empty, the length is :" + this.size);
        if(!(this.head.next == null))
            this.head = this.head.next;
        else {
            this.head = null;
            this.last = null;
        }
    }


    /**
     * get the First Node
     * @return Node
     */
    public Node<E> getHead() {
        return this.head;
    }

    /**
     * get the End Node
     * @return Node
     */
    public Node<E> getLast() {
        return this.last;
    }

    /**
     *if contains, return true, if not , return false
     * @param  data
     * @return boolean value
     */
    public boolean contain(E data) {
        if(isEmpty())
            throw new UnsupportedOperationException("your list is empty");
        Node<E> cur = this.head;
        while (cur.next != null){
            if(cur.data == data){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     *return the size of your list
     * @return the size of your list
     */
    public int size() {
        return this.size;
    }

}
