package com.example.assginment_mobileprograming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button signup;
    EditText id;
    EditText password;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);

        final StringBuffer data = new StringBuffer();
        login = findViewById(R.id.login);
        signup = findViewById(R.id.sign_up);
        id = findViewById(R.id.id);
        password = findViewById(R.id.password);
        test = findViewById(R.id.testView);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag=0;
                String i = id.getText().toString();
                String p = password.getText().toString();
                Intent intent = new Intent(MainActivity.this, CalActivity.class);

                try {
                    FileInputStream fis = openFileInput("id.txt");
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));
                    String str = buffer.readLine(); // 파일에서 한줄을 읽어옴
                    while (str != null) {
                        if(i.equals(str)){ flag=flag+1; }
                        str = buffer.readLine();
                    }
                    buffer.close();
                }
                catch (Exception e) { e.printStackTrace(); }
                try {
                    FileInputStream fis = openFileInput("pw.txt");
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));
                    String str = buffer.readLine(); // 파일에서 한줄을 읽어옴
                    while (str != null) {
                        if(p.equals(str)){ flag=flag+1; }
                        str = buffer.readLine();
                    }
                    buffer.close();
                }
                catch (Exception e) { e.printStackTrace(); }
                if(flag==2){ startActivity(intent); }
                else{ Toast.makeText(getApplicationContext(),"ID 또는 PW가 틀립니다.",Toast.LENGTH_LONG).show(); }
            }
        });
    }
}

