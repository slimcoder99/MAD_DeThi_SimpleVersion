package com.example.quanlyhocsinhsimpleversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quanlyhocsinhsimpleversion.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnAddStudent, btnAddClassroom, btnShowListStudent, btnShowListClassroom, btnShowStatistics, btnAddStudentToClassroom, btnShowNam, btnShowListStudentClassroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnAddClassroom = findViewById(R.id.btnAddClass);
        btnShowListStudent = findViewById(R.id.btnShowListStudent);
        btnShowListClassroom = findViewById(R.id.btnShowListClassroom);
        btnShowNam = findViewById(R.id.btnNam);
        btnShowStatistics = findViewById(R.id.btnStatistic);
        btnAddStudentToClassroom = findViewById(R.id.btnAddStudentToClass);
        btnShowListStudentClassroom = findViewById(R.id.btnShowListStudentClassroom);
        btnShowStatistics = findViewById(R.id.btnStatistic);

        DatabaseHelper db = new DatabaseHelper(this);
        db.deleteWrongStudent();

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });

        btnShowListStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowListActivity.class);
                intent.putExtra("type", "student_list");
                startActivity(intent);
            }
        });

        btnAddClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddClassroomActivity.class);
                startActivity(intent);
            }
        });

        btnShowListClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowListActivity.class);
                intent.putExtra("type", "classroom_list");
                startActivity(intent);
            }
        });

        btnShowNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowListActivity.class);
                intent.putExtra("type", "specific_list");
                startActivity(intent);
            }
        });

        btnAddStudentToClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentToClassActivity.class);
                startActivity(intent);
            }
        });

        btnShowListStudentClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowListActivity.class);
                intent.putExtra("type", "student_class_list");
                startActivity(intent);
            }
        });

        btnShowStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowListActivity.class);
                intent.putExtra("type", "statistic_list");
                startActivity(intent);
            }
        });

    }

}