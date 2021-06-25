package com.example.quanlyhocsinhsimpleversion.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quanlyhocsinhsimpleversion.model.ClassStatistic;
import com.example.quanlyhocsinhsimpleversion.model.Classroom;
import com.example.quanlyhocsinhsimpleversion.model.Student;
import com.example.quanlyhocsinhsimpleversion.model.StudentClass;

import java.sql.SQLData;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MAD_Database";
    public static final String STUDENT_TABLE_NAME = "Student";
    public static final String STUDENT_ID = "id";
    public static final String STUDENT_Name = "name";
    public static final String STUDENT_BIRTHDAY = "birthday";
    public static final String STUDENT_HOMETOWN = "hometown";
    public static final String STUDENT_YEAR_STUDY = "year_study";

    public static final String CLASS_TABLE_NAME = "Classroom";
    public static final String CLASS_ID = "id";
    public static final String CLASS_NAME = "name";
    public static final String CLASS_DESCRIPTION = "description";

    public static final String STUDENT_CLASS_TABLE_NAME = "Student_Class";
    public static final String STUDENT_CLASS_STUDENT_ID = "student_id";
    public static final String STUDENT_CLASS_CLASS_ID = "class_id";
    public static final String STUDENT_CLASS_SEMESTER = "semester";
    public static final String STUDENT_CLASS_CREDITS = "credits";

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlString1 = "CREATE TABLE " + STUDENT_TABLE_NAME + " (" +
                            STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                            STUDENT_Name + " TEXT NOT NULL," +
                            STUDENT_BIRTHDAY + " TEXT NOT NULL," +
                            STUDENT_HOMETOWN + " TEXT NOT NULL," +
                            STUDENT_YEAR_STUDY + " TEXT NOT NULL);";

        db.execSQL(sqlString1);

        String sqlString2 = "CREATE TABLE " + CLASS_TABLE_NAME + " (" +
                CLASS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CLASS_NAME + " TEXT NOT NULL," +
                CLASS_DESCRIPTION + " TEXT NOT NULL);";

        db.execSQL(sqlString2);

        String sqlString3 = "CREATE TABLE " + STUDENT_CLASS_TABLE_NAME + " (" +
                STUDENT_CLASS_STUDENT_ID + " INTEGER NOT NULL," +
                STUDENT_CLASS_CLASS_ID + " INTEGER NOT NULL," +
                STUDENT_CLASS_SEMESTER + " INTEGER NOT NULL," +
                STUDENT_CLASS_CREDITS + " INTEGER NOT NULL," +
                " FOREIGN KEY " + "(" + STUDENT_CLASS_STUDENT_ID + ") REFERENCES " + STUDENT_TABLE_NAME + "(" + STUDENT_ID + ")," +
                " FOREIGN KEY " + "(" + STUDENT_CLASS_CLASS_ID + ") REFERENCES " + STUDENT_TABLE_NAME + "(" + STUDENT_ID + "));";

        db.execSQL(sqlString3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sqlString1 = "DROP TABLE IF EXISTS " + STUDENT_TABLE_NAME;

        db.execSQL(sqlString1);

        String sqlString2 = "DROP TABLE IF EXISTS " + CLASS_TABLE_NAME;

        db.execSQL(sqlString2);

        String sqlString3 = "DROP TABLE IF EXISTS " + STUDENT_CLASS_TABLE_NAME;

        db.execSQL(sqlString3);
    }

    public void deleteWrongStudent() {
        String sqlString = "DELETE FROM " + STUDENT_TABLE_NAME + " WHERE " + STUDENT_YEAR_STUDY + "=?";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sqlString, new String[] {""});

        if(cursor.moveToFirst()) {

        }

        cursor.close();
        db.close();
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_Name, student.getName());
        contentValues.put(STUDENT_BIRTHDAY, student.getBirthday());
        contentValues.put(STUDENT_HOMETOWN, student.getHometown());
        contentValues.put(STUDENT_YEAR_STUDY, student.getYearStudy());

        db.insert(STUDENT_TABLE_NAME, null, contentValues);
        db.close();
    }

    public List<Student> getAllStudent() {
         String sqlString = "SELECT * FROM " + STUDENT_TABLE_NAME;

         List<Student> listStudents = new ArrayList<>();

         SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sqlString, null);

        if(cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setBirthday(cursor.getString(2));
                student.setHometown(cursor.getString(3));
                student.setYearStudy(cursor.getString(4));

                listStudents.add(student);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return  listStudents;
    }

    public void addClassroom(Classroom classroom) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(CLASS_NAME, classroom.getName());
        contentValues.put(CLASS_DESCRIPTION, classroom.getDescription());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(CLASS_TABLE_NAME, null, contentValues);

        db.close();
    }

    public List<Classroom> getAllClassroom() {
        List<Classroom> classroomList = new ArrayList<>();

        String sqlString = "SELECT * FROM " + CLASS_TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sqlString, null);

        if(cursor.moveToFirst()) {
            do {

                Classroom classroom = new Classroom();
                classroom.setId(cursor.getInt(0));
                classroom.setName(cursor.getString(1));
                classroom.setDescription(cursor.getString(2));

                classroomList.add(classroom);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return classroomList;
    }

    public List<Student> getSpecificStudent() {
        List<Student> studentList = new ArrayList<>();

        String sqlString = "SELECT * FROM " + STUDENT_TABLE_NAME + " WHERE " + STUDENT_Name + "=? AND " + STUDENT_YEAR_STUDY + "=?;";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sqlString, new String[]{"Nam", "Nam hai"});

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setBirthday(cursor.getString(2));
                student.setHometown(cursor.getString(3));
                student.setYearStudy(cursor.getString(4));

                studentList.add(student);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return  studentList;
    }

    public void addStudentToClass(StudentClass studentClass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_CLASS_STUDENT_ID, "" + studentClass.getStudentId());
        contentValues.put(STUDENT_CLASS_CLASS_ID, "" + studentClass.getClassroomId());
        contentValues.put(STUDENT_CLASS_SEMESTER, "" + studentClass.getSemester());
        contentValues.put(STUDENT_CLASS_CREDITS, "" + studentClass.getCredits());

        db.insert(STUDENT_CLASS_TABLE_NAME, null, contentValues);

        db.close();
    }

    public List<StudentClass> getAllStudentClass() {
        List<StudentClass> studentClassList = new ArrayList<>();

        String sqlString = "SELECT S." + STUDENT_ID + ", S." + STUDENT_Name + ", C." + CLASS_ID + ", C." + CLASS_NAME + ", SC." + STUDENT_CLASS_SEMESTER + ", SC." + STUDENT_CLASS_CREDITS + " FROM " + STUDENT_TABLE_NAME + " AS S JOIN "
                    + STUDENT_CLASS_TABLE_NAME + " AS SC " + " ON S." + STUDENT_ID + "=" + "SC." + STUDENT_CLASS_STUDENT_ID + " JOIN " + CLASS_TABLE_NAME + " AS C ON " + "C." + CLASS_ID
                    + "=SC." + STUDENT_CLASS_CLASS_ID + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sqlString, null);

        if(cursor.moveToFirst()) {
            do {
                StudentClass studentClass = new StudentClass();
                studentClass.setStudentId(cursor.getInt(0));
                studentClass.setStudentName(cursor.getString(1));
                studentClass.setClassroomId(cursor.getInt(2));
                studentClass.setClassroomName(cursor.getString(3));
                studentClass.setCredits(cursor.getInt(5));
                studentClass.setSemester(cursor.getInt(4));

                studentClassList.add(studentClass);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return studentClassList;
    }

    public List<ClassStatistic> getClassStatisticsByStudents() {
        List<ClassStatistic> classStatisticList = new ArrayList<>();

        String sqlString = "SELECT C." + CLASS_ID + ", C." + CLASS_NAME + ", COUNT(S." + STUDENT_ID + ") AS total_student FROM " + CLASS_TABLE_NAME + " AS C JOIN " + STUDENT_CLASS_TABLE_NAME
                        + " AS SC ON C." + CLASS_ID + "=" + "SC." + STUDENT_CLASS_CLASS_ID + " JOIN " + STUDENT_TABLE_NAME + " AS S ON SC." + STUDENT_CLASS_STUDENT_ID + "=" +
                        "S." + STUDENT_ID + " GROUP BY C." + CLASS_ID + " ORDER BY total_student DESC;" ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sqlString, null);

        if (cursor.moveToFirst()) {
            do {

                ClassStatistic classStatistic = new ClassStatistic();

                classStatistic.setClassId(cursor.getInt(0));
                classStatistic.setClassName(cursor.getString(1));
                classStatistic.setTotalStudent(cursor.getInt(2));

                classStatisticList.add(classStatistic);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return classStatisticList;
    }

}
