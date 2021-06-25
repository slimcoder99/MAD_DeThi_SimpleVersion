package com.example.quanlyhocsinhsimpleversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlyhocsinhsimpleversion.database.DatabaseHelper;
import com.example.quanlyhocsinhsimpleversion.model.Classroom;

public class AddClassroomActivity extends AppCompatActivity {

    private EditText etName, etDescription;
    private Button btnAddClassroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_classroom);

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDes);

        btnAddClassroom = findViewById(R.id.btnAddClass);

        btnAddClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String description = etDescription.getText().toString();

                Classroom classroom = new Classroom();
                classroom.setName(name);
                classroom.setDescription(description);

                DatabaseHelper db = new DatabaseHelper(AddClassroomActivity.this);

                db.addClassroom(classroom);

                finish();
            }
        });
    }
}