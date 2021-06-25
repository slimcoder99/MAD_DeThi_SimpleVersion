package com.example.quanlyhocsinhsimpleversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlyhocsinhsimpleversion.database.DatabaseHelper;
import com.example.quanlyhocsinhsimpleversion.model.Student;

import java.util.ArrayList;
import java.util.List;

public class AddStudentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText etName, etBirthday, etHometown;
    private Spinner etYearStudy;
    private Button btnAddStudent;
    private ListView listView;
    private String yearStudy = "";

    private String[] yearStudyData = new String[]{ "Nam nhat", "Nam hai", "Nam ba", "Nam bon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        etName = findViewById(R.id.etName);
        etBirthday = findViewById(R.id.etBirthday);
        etHometown = findViewById(R.id.etHometown);

        etYearStudy = findViewById(R.id.spinnerYearStudy);
        btnAddStudent = findViewById(R.id.btnAddStudent);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etName.getText()) || TextUtils.isEmpty(etBirthday.getText()) || TextUtils.isEmpty(etHometown.getText())) {
                    Toast.makeText(AddStudentActivity.this, "Please fill all this fields!", Toast.LENGTH_SHORT).show();
                } else {
                    String name = etName.getText().toString();
                    String birthday = etBirthday.getText().toString();
                    String hometown = etHometown.getText().toString();

                    Student student = new Student();
                    student.setName(name);
                    student.setBirthday(birthday);
                    student.setHometown(hometown);
                    student.setYearStudy(yearStudy);

                    DatabaseHelper db = new DatabaseHelper(AddStudentActivity.this);

                    db.addStudent(student);

                    Toast.makeText(AddStudentActivity.this, "Sucessfully add student!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, yearStudyData);
        etYearStudy.setAdapter(arrayAdapter);
        etYearStudy.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        yearStudy = yearStudyData[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        yearStudy = yearStudyData[0];
    }
}