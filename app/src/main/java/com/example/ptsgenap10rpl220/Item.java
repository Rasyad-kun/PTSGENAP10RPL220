package com.example.ptsgenap10rpl220;

public class Item {
    private String title, deskripsi;
    private int icon;

    public Item(String title, String deskripsi, int icon) {
        setTitle(title);
        setDeskripsi(deskripsi);
        setIcon(icon);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
