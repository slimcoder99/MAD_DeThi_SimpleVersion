package com.example.quanlyhocsinhsimpleversion.model;

public class Student {

    private int id;
    private String name;
    private String birthday;
    private String hometown;
    private String yearStudy;

    public Student() {
    }

    public Student(int id, String name, String birthday, String hometown, String yearStudy) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.hometown = hometown;
        this.yearStudy = yearStudy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getYearStudy() {
        return yearStudy;
    }

    public void setYearStudy(String yearStudy) {
        this.yearStudy = yearStudy;
    }

    @Override
    public String toString() {
        return "\nid= " + id +
                "\nname= '" + name + '\'' +
                "\nbirthday= '" + birthday + '\'' +
                "\n hometown= '" + hometown + '\'' +
                "\n yearStudy= '" + yearStudy + '\'';
    }
}
