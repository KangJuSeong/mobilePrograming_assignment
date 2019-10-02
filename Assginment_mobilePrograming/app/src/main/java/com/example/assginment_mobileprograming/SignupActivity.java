package com.example.assginment_mobileprograming;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SignupActivity extends AppCompatActivity {
    Button signup;
    EditText new_id;
    EditText new_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signup=findViewById(R.id.correct);
        new_id=findViewById(R.id.new_id);
        new_pw=findViewById(R.id.new_pw);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override    // 입력한 데이터를 파일에 추가로 저장하기
            public void onClick(View v) {
                String id = new_id.getText().toString();
                String pw = new_pw.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput("id.txt",Context.MODE_APPEND);
                    FileOutputStream fos1 = openFileOutput("pw.txt",Context.MODE_APPEND);
                    PrintWriter out = new PrintWriter(fos);
                    PrintWriter out1 = new PrintWriter(fos1);
                    out.println(id);
                    out1.println(pw);
                    out.close();
                    out1.close();
                    Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
