package com.example.assginment_mobileprograming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalActivity extends AppCompatActivity {

    static final int PLUS = 1;
    static final int MINUS = 2;
    static final int DIV = 3;
    static final int MULT = 4;

    Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
    Button plus,minus,div,mult,result,cancel;
    TextView show;
    double d1,d2,d3;
    String number1,number2;
    int operator=0;


    public void onClick (View v){
        switch(v.getId()){
            case R.id.num0 : show.setText(show.getText()+"0"); break;
            case R.id.num1 : show.setText(show.getText()+"1"); break;
            case R.id.num2 : show.setText(show.getText()+"2"); break;
            case R.id.num3 : show.setText(show.getText()+"3"); break;
            case R.id.num4 : show.setText(show.getText()+"4"); break;
            case R.id.num5 : show.setText(show.getText()+"5"); break;
            case R.id.num6 : show.setText(show.getText()+"6"); break;
            case R.id.num7 : show.setText(show.getText()+"7"); break;
            case R.id.num8 : show.setText(show.getText()+"8"); break;
            case R.id.num9 : show.setText(show.getText()+"9"); break;
        }
    };

    Button.OnClickListener mListener = new Button.OnClickListener(){
        public void onClick(View v){
            if(show.getText().toString()==null){
                Toast.makeText(CalActivity.this,"수를 입력하세요",Toast.LENGTH_SHORT).show();
            }
            switch (v.getId()){
                case R.id.plus:
                    number1=show.getText().toString();
                    operator=PLUS;
                    show.setText("");
                    break;
                case R.id.minus:
                    number1=show.getText().toString();
                    operator=MINUS;
                    show.setText("");
                    break;
                case R.id.div:
                    number1=show.getText().toString();
                    operator=DIV;
                    show.setText("");
                    break;
                case R.id.mult:
                    number1=show.getText().toString();
                    operator=MULT;
                    show.setText("");
                    break;
                case R.id.result:
                    number2=show.getText().toString();
                    d1=Double.parseDouble(number1);
                    d2=Double.parseDouble(number2);

                    if(operator == PLUS) {
                        d3 = d1 + d2;
                        show.setText("" + d3);
                    }
                    else if (operator == MINUS) {
                        d3 = d1 - d2;
                        show.setText("" + d3);
                    }
                    else if (operator == MULT) {
                        d3 = d1 * d2;
                        show.setText("" + d3);
                    }
                    else if (operator == DIV) {
                        d3 = d1 / d2;
                        show.setText("" + d3);
                    }
                    number1=show.getText().toString();
                    break;
                case R.id.cancel:
                    number1="";
                    number2="";
                    operator=0;
                    show.setText("");
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal);
        num0=findViewById(R.id.num0);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        num5=findViewById(R.id.num5);
        num6=findViewById(R.id.num6);
        num7=findViewById(R.id.num7);
        num8=findViewById(R.id.num8);
        num9=findViewById(R.id.num9);

        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        div=findViewById(R.id.div);
        mult=findViewById(R.id.mult);
        result=findViewById(R.id.result);
        cancel=findViewById(R.id.cancel);
        show=findViewById(R.id.show);

        plus.setOnClickListener(mListener);
        minus.setOnClickListener(mListener);
        mult.setOnClickListener(mListener);
        div.setOnClickListener(mListener);
        result.setOnClickListener(mListener);
        cancel.setOnClickListener(mListener);

    }
}
