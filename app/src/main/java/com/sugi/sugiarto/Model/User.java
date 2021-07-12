package com.sugi.sugiarto.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("first_name")
    private String nama1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama1() {
        return nama1;
    }

    public void setNama1(String nama1) {
        this.nama1 = nama1;
    }

    public String getNama2() {
        return nama2;
    }

    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @SerializedName("last_name")
    private String nama2;
    @SerializedName("email")
    private String email;

    public User(){}

    public User(String id, String nama1, String nama2, String email) {
        this.id = id;
        this.nama1 = nama1;
        this.nama2 = nama2;
        this.email = email;
    }


}
