package com.ashishjayan.trash2;

/**
 * Created by Ashish Jayan on 12/1/2017.
 */

public class Task {

    private int id;
    private String title;
    private String description;


    public Task() {}


    public Task(String title,String description){
        this.title=title;
        this.description=description;

    }

    public int getId(){
        return id;
    }

    public void setId(int i){
        this.id=id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

