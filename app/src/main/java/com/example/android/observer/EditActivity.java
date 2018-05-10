package com.example.android.observer;

/**
 * @author Anup
 *
 *
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class EditActivity extends AppCompatActivity {
    private UserEntity userEntity;


    private EditText userName;
    private EditText userAge;
    private EditText userEmail;
    private Button btnSave;
    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        userName = (EditText) findViewById(R.id.userName);
        userAge = (EditText) findViewById(R.id.userAge);
        userEmail = (EditText) findViewById(R.id.userEmail);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                Toast.makeText(getApplicationContext(),
                        "Data is Saved \n" +
                                "Kindly click Back button", Toast.LENGTH_LONG).show();

            }

        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        userEntity = UserEntity.getInstance();


        setupUserData();
    }

    private void setupUserData() {
        userName.setText(userEntity.getName());
        userAge.setText(String.valueOf(userEntity.getAge()));
        userEmail.setText(userEntity.getEmail());

    }

    private void updateData() {
        userEntity.setName(userName.getText().toString());
        userEntity.setAge(Integer.parseInt(userAge.getText().toString()));
        userEntity.setEmail(userEmail.getText().toString());
        userEntity.notifyObservers();


    }
}
