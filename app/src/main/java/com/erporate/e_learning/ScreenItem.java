package com.erporate.e_learning;

public class ScreenItem {
    String Title, Desc;
    int ScreenImage;

    public ScreenItem(String title, String desc, int screenImage) {
        Title = title;
        Desc = desc;
        ScreenImage = screenImage;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setScreenImage(int screenImage) {
        ScreenImage = screenImage;
    }

    public String getTitle() {
        return Title;
    }

    public String getDesc() {
        return Desc;
    }

    public int getScreenImage() {
        return ScreenImage;
    }
}
