package com.example.bibased.javabean;

public class HuipingMst {
    private String id;

    private String yuanuser;

    private String newuser;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getYuanuser() {
        return yuanuser;
    }

    public void setYuanuser(String yuanuser) {
        this.yuanuser = yuanuser == null ? null : yuanuser.trim();
    }

    public String getNewuser() {
        return newuser;
    }

    public void setNewuser(String newuser) {
        this.newuser = newuser == null ? null : newuser.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}