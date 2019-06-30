import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Classname MemoGroup
 * @Description TODO
 * @Date 2019/6/29 14:53
 * @Created by AppleTree
 */
public class MemoGroup {

    private int id;
    private String name;
    private LocalDateTime createdTime;
    private LocalDateTime modifyTime;

    public MemoGroup() {
    }

    public MemoGroup(int id, String name, LocalDateTime createdTime, LocalDateTime modifyTime) {
        this.id = id;
        this.name = name;
        this.createdTime = createdTime;
        this.modifyTime = modifyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
