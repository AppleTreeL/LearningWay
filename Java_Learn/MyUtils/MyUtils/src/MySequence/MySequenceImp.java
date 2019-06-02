package MySequence;

import java.util.Arrays;

/**
 * @Classname MySequenceImp
 * @Description TODO
 * @Date 2019/6/2 0:21
 * @Created by AppleTree
 */
public class MySequenceImp <T> implements ISequence {

    private Object[] elem;
    private int usedSize;
    private final int DEFAULT_SIZE = 8;

    public MySequenceImp() {
        this.elem = new Object[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    /**
     * 判断顺序表是否为满
     * @return if it is full, return true, otherwise return false
     */
    public boolean isFull(){
        if(this.usedSize == this.elem.length){
            return true;
        }else
            return false;
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    @Override
    public boolean add(int pos, Object data) {
       if(pos > this.usedSize || pos < 0){
           throw new IndexOutOfBoundsException("数组下标越界" + "pos" + pos);
       }

       if(isFull()){
           this.elem = Arrays.copyOf(this.elem, this.elem.length*2);
       }

       for(int i = this.usedSize - 1; i > pos; i --){
           this.elem[i + 1] = this.elem[i];
       }

       this.elem[pos] = data;
       this.usedSize += 1;
       return true;
    }

    @Override
    public int search(Object key) {
        if(isEmpty())
            throw new IndexOutOfBoundsException("顺序表为空" + this.usedSize);
        for(int i = 0; i < this.usedSize; i ++){
            if(this.elem[i] == key){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(isEmpty())
            throw new IndexOutOfBoundsException("顺序表为空" + this.usedSize);
        for(int i = 0; i < this.usedSize; i ++) {
            if (this.elem[i] == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos > this.usedSize || pos < 0){
            throw new IndexOutOfBoundsException("数组下标越界" + " at the input pos: " + pos);
        }
        return this.elem[pos];
    }

    @Override
    public Object remove(Object key) {
        if( !contains(key))
            throw new UnsupportedOperationException(key + "不存在");
        Object object = this.elem[search(key)];
        for(int i = search(key); i < this.usedSize; i ++) {
            this.elem[i] = this.elem[i + 1];
        }
        return object;
    }

    @Override
    public int size() {
        return this.elem.length;
        //return 0;
    }

    @Override
    public void display() {
        System.out.print("{ ");
        for(int i = 0; i < this.usedSize; i ++){
            System.out.print(this.elem[i] + ", ");
        }
        System.out.print("}");
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }
    }
}
