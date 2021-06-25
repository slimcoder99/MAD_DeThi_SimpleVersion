package com.example.quanlyhocsinhsimpleversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.quanlyhocsinhsimpleversion.database.DatabaseHelper;
import com.example.quanlyhocsinhsimpleversion.model.ClassStatistic;
import com.example.quanlyhocsinhsimpleversion.model.Classroom;
import com.example.quanlyhocsinhsimpleversion.model.Student;
import com.example.quanlyhocsinhsimpleversion.model.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class ShowListActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        listView = findViewById(R.id.listView);

        DatabaseHelper db = new DatabaseHelper(this);

        String type = getIntent().getStringExtra("type");

        List<String> listString = new ArrayList<>();

        if (type.equals("student_list")) {
            List<Student> listStudents = db.getAllStudent();

            for(Student student: listStudents) {
                listString.add(student.toString());
            }
        } else if (type.equals("classroom_list")) {
            List<Classroom> classroomList = db.getAllClassroom();

            for(Classroom classroom: classroomList) {
                listString.add(classroom.toString());
            }
        } else if (type.equals("specific_list")) {
            List<Student> studentList = db.getSpecificStudent();

            for(Student student: studentList) {
                listString.add(student.toString());
            }
        } else if (type.equals("student_class_list")){
            List<StudentClass> studentClassList = db.getAllStudentClass();

            for (StudentClass studentClass: studentClassList) {
                listString.add(studentClass.toString());
            }
        } else {
            List<ClassStatistic> classStatisticList = db.getClassStatisticsByStudents();

            for (ClassStatistic classStatistic: classStatisticList) {
                listString.add(classStatistic.toString());
            }
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listString);

        listView.setAdapter(arrayAdapter);
    }

}