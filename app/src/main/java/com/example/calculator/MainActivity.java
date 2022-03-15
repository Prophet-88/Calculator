package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);

        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldString = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftStr = oldString.substring(0, cursorPosition);
        String rightStr = oldString.substring(cursorPosition);

        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
        }

        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPosition + 1);
        }
    }

    public void buttonPlusMinus(View view){
        updateText("-");
    }

    public void buttonDecimal(View view){
        updateText(".");
    }

    public void buttonEqual(View view){
        String user_input = display.getText().toString();

        user_input = user_input.replaceAll("÷", "/");
        user_input = user_input.replaceAll("×","*");

        Expression exp = new Expression(user_input);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void buttonPlus(View view){
        updateText("+");
    }

    public void buttonMinus(View view){
        updateText("-");
    }

    public void buttonMultiply(View view){
        updateText("*");
    }

    public void buttonDivide(View view){
        updateText("/");
    }

    public void buttonExponent(View view){
        updateText("^");
    }

    public void buttonBracket(View view){

    }

    public void buttonClear(View view){
        display.setText("");
    }

    public void buttonBackspace(View view){

    }

    public void button0(View view){
        updateText("0");
    }

    public void button1(View view){
        updateText("1");
    }

    public void button2(View view){
        updateText("2");
    }

    public void button3(View view){
        updateText("3");
    }

    public void button4(View view){
        updateText("4");
    }

    public void button5(View view){
        updateText("5");
    }

    public void button6(View view){
        updateText("6");
    }

    public void button7(View view){
        updateText("7");
    }

    public void button8(View view){
        updateText("8");
    }

    public void button9(View view) {
        updateText("9");
    }

}