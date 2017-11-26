package com.birjot.gndec_sports.Latest_News;

/**
 * Created by birjot on 26/11/17.
 */

public class newsupload {


    public String heading;
    public String description;
    private String reg_token;
    public String datee;

    public newsupload(){

    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReg_token() {
        return reg_token;
    }

    public void setReg_token(String reg_token) {
        this.reg_token = reg_token;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    @Override
    public String toString() {
        return "newsupload{" +
                "heading='" + heading + '\'' +
                ", reg_token='" + reg_token + '\'' +
                ", description='" + description + '\'' +
                ", datee='" + datee + '\'' +
                '}';
    }
}
