package com.birjot.gndec_sports.Activities;

/**
 * Created by birjot on 6/11/17.
 */

public class Upload {


    public String name;
    public String url;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Upload() {
    }

    public Upload(String name, String url) {
        this.name = name;
        this.url= url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }



}
