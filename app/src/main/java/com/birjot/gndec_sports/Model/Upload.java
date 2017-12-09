package com.birjot.gndec_sports.Model;

/**
 * Created by birjot on 6/11/17.
 */

public class Upload {


    public String name;
    public String url;
    public String key;
    public String description;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Upload() {
    }

    public Upload(String name, String url, String key, String description) {
        this.name = name;
        this.url= url;
        this.key= key;
        this.description= description;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
