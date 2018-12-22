package User;

import java.util.List;

public class Message {
    private int id;
    private String username;
    private String text;
    private int pid;
    //子节点
    private List<Message> childcntent;

    public Message() {
    }

    public Message(String username, String text, int pid) {
        this.username = username;
        this.text = text;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<Message> getChildcntent() {
        return childcntent;
    }

    public void setChildcntent(List<Message> childcntent) {
        this.childcntent = childcntent;
    }
}
