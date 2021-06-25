package com.example.quanlyhocsinhsimpleversion.model;

public class StudentClass {

    private int studentId;
    private int classroomId;
    private String studentName;
    private String classroomName;
    private int semester;
    private int credits;

    public StudentClass() {
    }

    public StudentClass(int studentId, int classroomId, String studentName, String classroomName, int semester, int credits) {
        this.studentId = studentId;
        this.classroomId = classroomId;
        this.studentName = studentName;
        this.classroomName = classroomName;
        this.semester = semester;
        this.credits = credits;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "studentId=" + studentId +
                "\nclassroomId=" + classroomId +
                "\nstudentName='" + studentName + '\'' +
                "\nclassroomName='" + classroomName + '\'' +
                "\nsemester=" + semester +
                "\ncredits=" + credits;
    }
}
