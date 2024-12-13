package com.education.ztu;

public abstract class BaseModel {
    private int id;

    public BaseModel(){
        this.id = 0;
    }

    public BaseModel(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
