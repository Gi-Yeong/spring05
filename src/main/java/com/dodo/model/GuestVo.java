package com.dodo.model;

import java.util.Date;

public class GuestVo {
    private int sabun;
    private String name;
    private Date nalja;
    private int pay;

    public GuestVo() {
    }

    public GuestVo(int sabun, String name, Date nalja, int pay) {
        this.sabun = sabun;
        this.name = name;
        this.nalja = nalja;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "GuestVo{" +
                "sabun=" + sabun +
                ", name='" + name + '\'' +
                ", nalja=" + nalja +
                ", pay=" + pay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GuestVo)) return false;

        GuestVo guestVo = (GuestVo) o;

        if (getSabun() != guestVo.getSabun()) return false;
        if (getPay() != guestVo.getPay()) return false;
        return getName() != null ? getName().equals(guestVo.getName()) : guestVo.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getSabun();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getPay();
        return result;
    }

    public int getSabun() {
        return sabun;
    }

    public void setSabun(int sabun) {
        this.sabun = sabun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNalja() {
        return nalja;
    }

    public void setNalja(Date nalja) {
        this.nalja = nalja;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }
}
