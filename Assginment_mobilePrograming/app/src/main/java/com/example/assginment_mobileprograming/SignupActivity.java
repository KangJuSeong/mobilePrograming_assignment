package com.example.assginment_mobileprograming;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SignupActivity extends AppCompatActivity {
    Button signup;
    Button cheak;
    EditText new_id;
    EditText new_pw;
    int overlap = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signup=findViewById(R.id.correct);
        new_id=findViewById(R.id.new_id);
        new_pw=findViewById(R.id.new_pw);
        cheak=findViewById(R.id.cheak);

        cheak.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String current_id = new_id.getText().toString();
                try {
                    FileInputStream fis = openFileInput("id.txt");
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));
                    String str = buffer.readLine(); // 파일에서 한줄을 읽어옴
                    while (str != null) {
                        if(current_id.equals(str)){
                            Toast.makeText(getApplicationContext(),"중복된 ID가 존재합니다.",Toast.LENGTH_LONG).show();
                            break;
                        }
                        overlap =1;
                        str = buffer.readLine();
                    }
                    buffer.close();
                }
                catch (Exception e) { e.printStackTrace(); }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override    // 입력한 데이터를 파일에 추가로 저장하기
            public void onClick(View v) {
                String id = new_id.getText().toString();
                String pw = new_pw.getText().toString();

                if(overlap == 1){
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
                    }
                    catch (Exception e) { e.printStackTrace(); }
                }
                else {Toast.makeText(getApplicationContext(),"중복체크를 해주세요",Toast.LENGTH_LONG).show();}
            }
        });
    }
}
