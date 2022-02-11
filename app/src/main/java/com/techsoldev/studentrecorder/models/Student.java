package com.techsoldev.studentrecorder.models;

public class Student {
    private String name , section ;
    private int image;

    public Student() {
    }

    public Student(String name, String section, int image) {
        this.name = name;
        this.section = section;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
