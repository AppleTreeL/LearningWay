import java.time.LocalTime;

/**
 * @Classname MemoInfo
 * @Description TODO
 * @Date 2019/6/29 14:56
 * @Created by AppleTree
 */
public class MemoInfo {


    private int id;
    private int group_id;
    private String title;
    private String content;
    private String isProtected;
    private Color backGround;
    private String isRemind;
    private LocalTime remindTime;
    private LocalTime createdTime;
    private LocalTime modifyTime;


    public MemoInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsProtected() {
        return isProtected;
    }

    public void setIsProtected(String isProtected) {
        this.isProtected = isProtected;
    }

    public Color getBackGround() {
        return backGround;
    }

    public void setBackGround(Color backGround) {
        this.backGround = backGround;
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind;
    }

    public LocalTime getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(LocalTime remindTime) {
        this.remindTime = remindTime;
    }

    public LocalTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoInfo{" +
                "id=" + id +
                ", group_id=" + group_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isProtected='" + isProtected + '\'' +
                ", backGround=" + backGround +
                ", isRemind='" + isRemind + '\'' +
                ", remindTime=" + remindTime +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}

enum Color{
    WHITE, BlACK, PINK, BLUE, GREEN, RED;
}
