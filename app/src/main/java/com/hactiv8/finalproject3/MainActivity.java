package com.hactiv8.finalproject3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {


    TextView inputText, outputText;
    String process;
    boolean checkBracket = false;

    Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonAdd, buttonMultiply, buttonSubs, buttonDivision, buttonPoint, buttonPercent, buttonEqual, buttonClear, btnBracket, btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonAdd = findViewById(R.id.addition_btn); //plus
        buttonMultiply = findViewById(R.id.multiply_btn); //kali
        buttonDivision = findViewById(R.id.division_btn); //bagi
        buttonSubs = findViewById(R.id.substraction_btn); //min
        buttonPoint = findViewById(R.id.btnpoint); //koma
        buttonEqual = findViewById(R.id.equal_btn); //=
        buttonPercent = findViewById(R.id.percent_btn); //persen
        buttonClear = findViewById(R.id.clear_btn);
        btnBracket = findViewById(R.id.btnBracket);
        btnDel = findViewById(R.id.btndel);

        inputText = findViewById(R.id.input_text);
        outputText = findViewById(R.id.output_text);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("");
                outputText.setText("");
            }
        });


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "+");
            }
        });

        buttonSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "×");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "÷");
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + ".");
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                inputText.setText(process + "%");
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBracket){
                    process = inputText.getText().toString();
                    inputText.setText(process + ")");
                    checkBracket = false;
                }else{
                    process = inputText.getText().toString();
                    inputText.setText(process + "(");
                    checkBracket = true;
                }

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = inputText.getText().toString();
                val = val.substring(0, val.length() - 1);
                inputText.setText(val);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputText.getText().toString();
                process = process.replaceAll("×","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll("÷","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="Error";
                }

                outputText.setText(finalResult);
            }
        });
    }
}
