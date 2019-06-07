package MyLinkedList;

import java.util.NoSuchElementException;

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

    /**
     * get previous node of current node
     * @param cur current node, you need its previous node
     * @return previous node
     */
    public Node<E> getPrevious(Node<E> cur) {
        Node<E> pre = this.head;
        while (pre.next != null){
            if(pre.next == cur){
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    /**
     * delete the node you selected
     * @param data  the part of the data of the node that you will delete
     */
    public void remove(E data){
        if(isEmpty())
            throw new UnsupportedOperationException("your list is empty, the size is :" + this.size);
        Node<E> cur = this.head;
        Node<E> temp = null;
        while (cur.next != null){
            if(cur == this.head){
                this.head = this.head.next;
            }else{
                if(cur.data == data) {
                    Node<E> pre = getPrevious(cur);
                    pre.next = cur.next;
                }
            }
            cur = cur.next;
        }
        System.err.println("你要删除的节点不在本链表");
    }


    /**
     * remove the elem by index
     * @param index , it is the location of the node you want to delete
     */
    public void remove(int index) {

        if(index > this.size || index < 0){
            throw new IndexOutOfBoundsException("该位置不存在" + index);
        }

        if(index == 0){
            this.head = this.head.next;
        }

        int counter = 0;

        Node<E> cur = this.head;
        while(cur.next != null){
            if(counter == index){
                Node<E> pre = getPrevious(cur);
                pre.next = cur.next;
            }
            cur = cur.next;
        }
    }

    /**
     * delete all the nodes of the list
     */
    public void clear(){
        this.head = null;
        this.last = null;
    }

    /**
     * get the node by index
     * @param index , the index of the node you want to get
     * @return node that you want to get
     */
    public Node<E> get(int index) {
        if(index > this.size - 1 || index < 0)
            throw new IndexOutOfBoundsException("数组下标越界" + index);
        int count = 0;
        Node<E> cur = this.head;
        while (cur.next != null){
            if(count == index){
                return cur;
            }
            cur = cur.next;
            count += 1;
        }
        return null;
    }

    /**
     * replace the node at the index location
     * @param data and index, use data to initial the node to replace,
     *            index point the location you are inserting
     * @param index
     */
    public void set(E data, int index) {
        if(index > this.size || index < 0)
            throw new IndexOutOfBoundsException("该位置越界" + index);
        Node<E> cur = this.head;
        Node<E> node = new Node<>(data);
        int count  = 0;
        while (cur.next != null){
            if(count == index) {
                if(cur == this.head) {
                    node.next = cur.next;
                    this.head = node;
                    return;
                }

                if(cur == this.last){
                    Node<E> pre = getPrevious(cur);
                    pre.next = node;
                    this.last = node;
                    return;
                }
                Node<E> pre = getPrevious(cur);
                node.next = cur.next;
                pre.next = node;
            }
            cur = cur.next;
            count += 1;
        }
    }

    /**
     * add node to the pointed location by index
     * @param data the data of data
     * @param index location of the list
     */
    public void  add(E data, int index) {
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException("插入位置不存在" + index);
        }

        if(isEmpty()) {
            addFirst(data);
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == this.size -1){
            addLast(data);
            return;
        }

        Node<E> node = new Node<>(data);
        int count = 0;
        Node<E> cur = this.head;
        while (cur.next != null){
            if(index == count){
                Node<E> pre = getPrevious(cur);
                node.next = cur;
                pre.next = node;
                return;
            }
        }

    }

}
