package com.company;

import javafx.scene.control.DatePicker;

public class Tasks {

    private String title;
    private String date;
    private String note;

    public Tasks(){
        this.title = "";
        this.date = "";
        this.note = "";
    }

    public Tasks(String title, String date, String note){
        this.title = title;
        this.date = date;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
