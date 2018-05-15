package com.jey_dev.lib.dialog.data;



/**
 * Created by JeYHoon on 2018. 1. 13..
 */

public class JPermissionNotifyData {
    private int icResId=0x00;
    private int stringResId=0x00;
    private boolean isNecessary=false;
    private String desc="";

    public JPermissionNotifyData(int icResId, int stringResId, boolean isNecessary, String desc) {
        this.icResId = icResId;
        this.stringResId = stringResId;
        this.isNecessary = isNecessary;
        this.desc = desc;
    }

    public JPermissionNotifyData(int icResId, int stringResId, String desc) {
        this.icResId = icResId;
        this.stringResId = stringResId;
        this.desc = desc;
    }

    public int getIcResId() {
        return icResId;
    }

    public void setIcResId(int icResId) {
        this.icResId = icResId;
    }

    public int getStringResId() {
        return stringResId;
    }

    public void setStringResId(int stringResId) {
        this.stringResId = stringResId;
    }

    public boolean isNecessary() {
        return isNecessary;
    }

    public void setNecessary(boolean necessary) {
        isNecessary = necessary;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
