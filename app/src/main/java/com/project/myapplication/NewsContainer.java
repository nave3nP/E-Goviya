package com.project.myapplication;

import java.util.Date;

public class NewsContainer {
    String Title,Description;
    Date Time;

    public NewsContainer(){}

    public NewsContainer(String title, String description,Date time) {
        Title = title;
        Description = description;
        Time =time;

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }
}
