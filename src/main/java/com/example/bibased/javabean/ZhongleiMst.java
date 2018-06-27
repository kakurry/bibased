package com.example.bibased.javabean;

import java.util.Date;

public class ZhongleiMst {
    private String id;

    private String caixi;

    private String lishu;

    private String description;

    private Date createtime;

    private Date updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCaixi() {
        return caixi;
    }

    public void setCaixi(String caixi) {
        this.caixi = caixi == null ? null : caixi.trim();
    }

    public String getLishu() {
        return lishu;
    }

    public void setLishu(String lishu) {
        this.lishu = lishu == null ? null : lishu.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}