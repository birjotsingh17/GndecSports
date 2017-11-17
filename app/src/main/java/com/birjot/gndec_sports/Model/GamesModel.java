package com.birjot.gndec_sports_admin.Model;

/**
 * Created by birjot on 13/11/17.
 */

public class GamesModel {

    int icon;
    String Name;


    GamesModel()
    {

    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public GamesModel(int icon, String name) {
        this.icon = icon;
        Name = name;
    }

    @Override
    public String toString() {
        return "GamesModel{" +
                "icon=" + icon +
                ", Name='" + Name + '\'' +
                '}';
    }
}
