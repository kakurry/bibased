package com.example.bibased.javabean;

import java.util.Date;

public class DianpuMst {
    private String id;

    private String img;

    private String dianming;

    private String neirong1;

    private String neirong2;

    private String neirong3;

    private Date createtime;

    private Date updatetime;

    private String dizhi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDianming() {
        return dianming;
    }

    public void setDianming(String dianming) {
        this.dianming = dianming == null ? null : dianming.trim();
    }

    public String getNeirong1() {
        return neirong1;
    }

    public void setNeirong1(String neirong1) {
        this.neirong1 = neirong1 == null ? null : neirong1.trim();
    }

    public String getNeirong2() {
        return neirong2;
    }

    public void setNeirong2(String neirong2) {
        this.neirong2 = neirong2 == null ? null : neirong2.trim();
    }

    public String getNeirong3() {
        return neirong3;
    }

    public void setNeirong3(String neirong3) {
        this.neirong3 = neirong3 == null ? null : neirong3.trim();
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

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }
}