package com.toramoss.calculator;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigInteger;


public class MainActivity extends ActionBarActivity {
    static StringBuilder textOnScreen = new StringBuilder("");
    static String operand = "";
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
        Intent intent = this.getIntent();
        CharSequence test = intent.getCharSequenceExtra("textOnScreen");
        if(test != null) {
            textOnScreen = new StringBuilder(test);
            text.setText(textOnScreen);
        }
        CharSequence operand = intent.getCharSequenceExtra("operand");
        if(operand != null){
            this.operand = operand.toString();
            Log.i("The operand is: " , operand.toString());
        }

        Button one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("1");
                text.setText(textOnScreen);
            }
        });
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("2");
                text.setText(textOnScreen);
            }
        });
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("3");
                text.setText(textOnScreen);
            }
        });
        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("4");
                text.setText(textOnScreen);
            }
        });
        Button five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("5");
                text.setText(textOnScreen);
            }
        });
        Button six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("6");
                text.setText(textOnScreen);
            }
        });
        Button seven = (Button) findViewById(R.id.button7);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("7");
                text.setText(textOnScreen);
            }
        });
        Button eight = (Button) findViewById(R.id.button8);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("8");
                text.setText(textOnScreen);
            }
        });
        Button nine = (Button) findViewById(R.id.button9);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("9");
                text.setText(textOnScreen);
            }
        });
        Button zero = (Button) findViewById(R.id.button0);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("0");
                text.setText(textOnScreen);
            }
        });
        Button decimal = (Button) findViewById(R.id.buttonDecimal);
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append(".");
                text.setText(textOnScreen);
            }
        });
        Button equals = (Button) findViewById(R.id.buttonEquals);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = calculateAnswer();
                textOnScreen = new StringBuilder(answer);
                text.setText(textOnScreen);
            }
        });
        Button plus = (Button) findViewById(R.id.buttonPlus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("+");
                MainActivity.this.operand = "\\+";
                text.setText(textOnScreen);
            }
        });
        Button minus = (Button) findViewById(R.id.buttonMinus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("-");
                MainActivity.this.operand = "\\-";
                text.setText(textOnScreen);
            }
        });
        Button multiply = (Button) findViewById(R.id.buttonMultiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("x");
                MainActivity.this.operand = "x";
                text.setText(textOnScreen);
            }
        });
        Button divide = (Button) findViewById(R.id.buttonDivide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("/");
                MainActivity.this.operand = "/";
                text.setText(textOnScreen);
            }
        });
        Button delete = (Button) findViewById(R.id.buttonDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textOnScreen.length() - 1 < 0){
                    return;
                }
                else {
                    textOnScreen.deleteCharAt(textOnScreen.length() - 1);
                    text.setText(textOnScreen);
                }
            }
        });
        this.disableSoftInputFromAppearing(text);
    }


    // Create Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.advanced){
            Intent intent = new Intent(MainActivity.this, AdvancedActivity.class);
            intent.putExtra("textOnScreen", textOnScreen.toString());
            intent.putExtra("operand", operand);
            startActivity(intent);
            MainActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public static void disableSoftInputFromAppearing(EditText editText) {
        if (Build.VERSION.SDK_INT >= 11) {
            editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
            editText.setTextIsSelectable(true);
        } else {
            editText.setRawInputType(InputType.TYPE_NULL);
            editText.setFocusable(true);
        }
    }

    public static String calculateAnswer(){
        if(operand.equals("LOG ")){
            String values[] = textOnScreen.toString().split(" ");
            double d1 = Double.parseDouble(values[1]);
            return Math.log10(d1) + "";
        }
        if(operand.equals("SIN ")){
            String values[] = textOnScreen.toString().split(" ");
            double d1 = Double.parseDouble(values[1]);
            return Math.sin(d1) + "";
        }
        if(operand.equals("COS ")){
            String values[] = textOnScreen.toString().split(" ");
            double d1 = Double.parseDouble(values[1]);
            return Math.cos(d1) + "";
        }
        if(operand.equals("TAN ")){
            String values[] = textOnScreen.toString().split(" ");
            double d1 = Double.parseDouble(values[1]);
            return Math.tan(d1) + "";
        }
        if(operand.equals("COS ")){
            String values[] = textOnScreen.toString().split(" ");
            double d1 = Double.parseDouble(values[1]);
            return Math.cos(d1) + "";
        }
        if(operand.equals("LN ")){
            String values[] = textOnScreen.toString().split(" ");
            double d1 = Double.parseDouble(values[1]);
            return Math.log(d1) + "";
        }
        if(operand.equals(" !")){
            String values[] = textOnScreen.toString().split(" ");
            int d1 = Integer.parseInt(values[0]);
            BigInteger answer = new BigInteger("1");
            for(int i = d1; i >= 1; i--){
                answer = answer.multiply(new BigInteger(i + ""));
            }
            return answer.toString();
        }
        if(operand.equals("sqrt ")){
            String values[] = textOnScreen.toString().split(" ");
            double d1 = Double.parseDouble(values[1]);
            return Math.sqrt(d1) + "";
        }


        String[] values = textOnScreen.toString().split(operand);
        if(values[0].contains(".") || values[1].contains(".")){
            double d1 = Double.parseDouble(values[0]);
            double d2 = Double.parseDouble(values[1]);
            if(operand.equals("\\+")){
                double answer = d1 + d2;
                return answer + "";
            }

            else if(operand.equals("\\-")){
                double answer = d1 - d2;
                return answer + "";
            }
            else if(operand.equals("x")){
                double answer = d1 * d2;
                return answer + "";
            }
            else if(operand.equals("/")){
                double answer = d1 / d2;
                return answer + "";
            }
        }
        else{
            int d1 = Integer.parseInt(values[0]);
            int d2 = Integer.parseInt(values[1]);
            if(operand.equals("\\+")){
                int answer = d1 + d2;
                return answer + "";
            }

            else if(operand.equals("\\-")){
                int answer = d1 - d2;
                return answer + "";
            }
            else if(operand.equals("x")){
                int answer = d1 * d2;
                return answer + "";
            }
            else if(operand.equals("/")){
                double a = d1;
                double b = d2;
                double answer = a / b;
                return answer + "";
            }
            else if(operand.equals("%")){
                int answer = d1 % d2;
                return answer + "";
            }
            else if(operand.equals("\\^")){
                int answer = (int)Math.pow(d1, d2);
                return answer + "";
            }
        }

        return null;
    }
}
