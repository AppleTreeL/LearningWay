package MyProducerConsumerPattern;

/**
 * @Classname Goods
 * @Description TODO
 * @Date 2019/6/11 21:16
 * @Created by AppleTree
 */
public class Goods {
    private String name;
    private int id;

    public Goods(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
