package com.education.ztu.Task4;

@Model(tableName = "_user")
public class UserModel extends BasicModel{
    public String name;
    public String email;

    public UserModel(String name, String email){
        this.name = name;
        this.email = email;
    }
}
