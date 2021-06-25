package com.example.quanlyhocsinhsimpleversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.quanlyhocsinhsimpleversion.database.DatabaseHelper;
import com.example.quanlyhocsinhsimpleversion.model.Classroom;
import com.example.quanlyhocsinhsimpleversion.model.Student;
import com.example.quanlyhocsinhsimpleversion.model.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class AddStudentToClassActivity extends AppCompatActivity {

    private Spinner  spinnerStudent, spinnerClassroom, spinnerSemester, spinnerCredits;
    private Button btnAdd;
    private int student_id = 0;
    private int classroom_id = 0;
    private int semester = 0;
    private int credits = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_to_class);

        spinnerStudent = findViewById(R.id.spinnerStudent);
        spinnerClassroom = findViewById(R.id.spinnerClassroom);
        spinnerSemester = findViewById(R.id.spinnerSemester);
        spinnerCredits = findViewById(R.id.spinnerCredits);

        btnAdd = findViewById(R.id.btnAdd);


        DatabaseHelper db = new DatabaseHelper(this);

        List<Student> studentList = db.getAllStudent();
        List<Classroom> classroomList = db.getAllClassroom();

        List<String> studentSpinnerData = new ArrayList<>();
        List<String> classroomSpinnerData = new ArrayList<>();

        for (Student student: studentList) {
            String data = "ID: " + student.getId() + ", Name: " + student.getName();
            studentSpinnerData.add(data);
        }

        for (Classroom classroom: classroomList) {
            String data = "ID: " + classroom.getId() + ", Name: " + classroom.getName();
            classroomSpinnerData.add(data);
        }

        ArrayAdapter<String> arrayAdapterStudent = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentSpinnerData);
        ArrayAdapter<String> arrayAdapterClassroom = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classroomSpinnerData);

        spinnerStudent.setAdapter(arrayAdapterStudent);
        spinnerClassroom.setAdapter(arrayAdapterClassroom);

        spinnerStudent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                student_id = studentList.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerClassroom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                classroom_id = classroomList.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String[] semesterData = new String[] {"1", "2", "3"};
        String[] creditsData = new String[] {"1", "2", "3", "4"};

        ArrayAdapter<String> arrayAdapterSemester = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, semesterData);
        ArrayAdapter<String> arrayAdapterCredits = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, creditsData);

        spinnerSemester.setAdapter(arrayAdapterSemester);
        spinnerCredits.setAdapter(arrayAdapterCredits);

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semester = Integer.valueOf(semesterData[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCredits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                credits = Integer.valueOf(creditsData[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentClass studentClass = new StudentClass();
                studentClass.setStudentId(student_id);
                studentClass.setClassroomId(classroom_id);
                studentClass.setSemester(semester);
                studentClass.setCredits(credits);

                db.addStudentToClass(studentClass);
                finish();
            }
        });
    }
}