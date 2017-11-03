package com.birjot.gndec_sports.Model;

/**
 * Created by birjot on 1/11/17.
 */





public class User {

    private String university;
    private String username;
    private String email;
    private String password;
    private String ph;
    private String gender;
    private String city;
    private String reg_token;

    public User() {}

    public User(String university, String username, String email, String password, String ph, String gender, String city, String reg_token) {
        this.university = university;
        this.username = username;
        this.email = email;
        this.password = password;
        this.ph =ph;
        this.gender = gender;
        this.city = city;
        this.reg_token = reg_token;
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReg_token() {
        return reg_token;
    }

    public void setReg_token(String reg_token) {
        this.reg_token = reg_token;
    }

    @Override
    public String toString() {
        return "User{" +
                "university ='" + university + '\'' +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ph='" + ph + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", reg_token='" + reg_token + '\'' +
                '}';
    }
}

