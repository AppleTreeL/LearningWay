package MySequence;

/**
 * @Classname ISequence
 * @Description TODO
 * @Date 2019/6/2 0:20
 * @Created by AppleTree
 */
public interface ISequence <T> {
    //在pos位置插入data
    boolean add(int pos,T data);

    //查找关键字key 找到返回key的下标，没有返回-1;
    int search(T key);

    //查找是否包含关键字key是否在顺序表当中(这个和search有点冲突)
    boolean contains(T key);

    //得到pos位置的值
    Object getPos(int pos);

    //删除第一次出现的关键字key
    Object remove(T key);

    //得到顺序表的长度
    int size();

    //打印顺序表
    void display();

    //清空顺序表以防内存泄漏
    void clear();
}
