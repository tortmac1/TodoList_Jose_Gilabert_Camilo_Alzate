package com.example.todolist_jose_gilabert_camilo_alzate;

import java.io.Serializable;

public class Tarea implements Serializable {
    private Integer userId;
    private Integer id;
    private String title;
    private boolean completed;


    public Tarea(String title) {
        this.title = title;
        this.completed = false;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


}
