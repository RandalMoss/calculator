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


public class AdvancedActivity extends ActionBarActivity {
    static StringBuilder textOnScreen = new StringBuilder("");
    static String operand = "";
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        text = (EditText) findViewById(R.id.editText);
        Intent intent = this.getIntent();
        textOnScreen = new StringBuilder(intent.getCharSequenceExtra("textOnScreen"));
        text.setText(textOnScreen);

        CharSequence o = intent.getCharSequenceExtra("operand");
        if(o != null){
            this.operand = o.toString();
            Log.i("The operand is: ", o.toString());
        }

        Button sin = (Button) findViewById(R.id.buttonSin);
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("SIN ");
                operand = "SIN ";
                text.setText(textOnScreen);
            }
        });
        Button cos = (Button) findViewById(R.id.buttonCos);
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("COS ");
                operand = "COS";
                text.setText(textOnScreen);
            }
        });
        Button tan = (Button) findViewById(R.id.buttonTan);
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("TAN ");
                operand = "TAN ";
                text.setText(textOnScreen);
            }
        });
        Button i = (Button) findViewById(R.id.buttonI);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("i");
                text.setText(textOnScreen);
            }
        });
        Button ln = (Button) findViewById(R.id.buttonLn);
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("LN ");
                operand = "LN ";
                text.setText(textOnScreen);
            }
        });
        Button log = (Button) findViewById(R.id.buttonLog);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("LOG ");
                operand = "LOG ";
                text.setText(textOnScreen);
            }
        });
        Button pi = (Button) findViewById(R.id.buttonPi);
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("3.141");
                text.setText(textOnScreen);
            }
        });
        Button e = (Button) findViewById(R.id.buttonE);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append(Math.E);
                text.setText(textOnScreen);
            }
        });
        Button mod = (Button) findViewById(R.id.buttonMod);
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("%");
                operand = "%";
                text.setText(textOnScreen);
            }
        });
        Button factorial = (Button) findViewById(R.id.buttonFactorial);
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append(" !");
                operand = " !";
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
        Button sqrt = (Button) findViewById(R.id.buttonSqrt);
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("sqrt ");
                operand = "sqrt ";
                text.setText(textOnScreen);
            }
        });
        Button pow = (Button) findViewById(R.id.buttonPow);
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("^");
                operand = "\\^";
                text.setText(textOnScreen);
            }
        });
        Button left = (Button) findViewById(R.id.buttonLeft);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append("(");
                operand = "(";
                text.setText(textOnScreen);
            }
        });
        Button right = (Button) findViewById(R.id.buttonRight);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOnScreen.append(")");
                operand = ")";
                text.setText(textOnScreen);
            }
        });
        this.disableSoftInputFromAppearing(text);
    }


    // Create Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_advanced, menu);
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
        else if(id == R.id.basic){
            Intent intent = new Intent(AdvancedActivity.this, MainActivity.class);
            intent.putExtra("textOnScreen", textOnScreen.toString());
            intent.putExtra("operand", operand);
            startActivity(intent);
            AdvancedActivity.this.finish();
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
}
