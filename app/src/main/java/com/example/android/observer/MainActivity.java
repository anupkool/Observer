package com.example.android.observer;


/**
 * @author Anup
 *
 *
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {
    private UserEntity userEntity;
    private TextView userName;
    private TextView userAge;
    private TextView userEmail;
    private Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName = (TextView) findViewById(R.id.userName);
        userAge = (TextView) findViewById(R.id.userAge);
        userEmail = (TextView) findViewById(R.id.userEmail);
        btnEdit = (Button) findViewById(R.id.btnEdit);

        userEntity = UserEntity.getInstance();
        userEntity.addObserver(this);
        loadDataUser();


        btnEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EditActivity.class));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userEntity.deleteObserver(this);
    }



    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof UserEntity) {
            userName.setText(userEntity.getName());
            userAge.setText(String.valueOf(userEntity.getAge()));
            userEmail.setText(userEntity.getEmail());
        }
    }

    private void loadDataUser() {
        userEntity.setName("Anup")
                .setAge(27)
                .setEmail("xyz@gmail.com");

        userEntity.notifyObservers();
    }
    
}
