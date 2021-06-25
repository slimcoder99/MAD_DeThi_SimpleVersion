package com.example.quanlyhocsinhsimpleversion.model;

public class ClassStatistic {

    private int classId;
    private String className;
    private int totalStudent;

    public ClassStatistic() {
    }

    public ClassStatistic(int classId, String className, int totalStudent) {
        this.classId = classId;
        this.className = className;
        this.totalStudent = totalStudent;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    @Override
    public String toString() {
        return "\nclassId=" + classId +
                "\nclassName='" + className + '\'' +
                "\ntotalStudent=" + totalStudent;
    }
}
