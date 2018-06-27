package com.example.bibased.javabean;

import java.util.Date;

public class JapancaiMst {
    private String id;

    private String img;

    private String caiming;

    private String neirong1;

    private String neirong2;

    private String neirong3;

    private String neirong4;

    private String neirong5;

    private Date createtime;

    private Date updatetime;

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

    public String getCaiming() {
        return caiming;
    }

    public void setCaiming(String caiming) {
        this.caiming = caiming == null ? null : caiming.trim();
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

    public String getNeirong4() {
        return neirong4;
    }

    public void setNeirong4(String neirong4) {
        this.neirong4 = neirong4 == null ? null : neirong4.trim();
    }

    public String getNeirong5() {
        return neirong5;
    }

    public void setNeirong5(String neirong5) {
        this.neirong5 = neirong5 == null ? null : neirong5.trim();
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