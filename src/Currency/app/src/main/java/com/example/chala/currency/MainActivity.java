//Homework1
//MainActivity.java
//Dhenuka

package com.example.chala.currency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button convert_to = (Button)findViewById(R.id.button_convert);
        convert_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("demo","convert");
                RadioButton radioButton_aud = (RadioButton)findViewById(R.id.radioButton_aud);
                RadioButton radioButton_cad = (RadioButton)findViewById(R.id.radioButton_cad);
                RadioButton radioButton_inr = (RadioButton)findViewById(R.id.radioButton_inr);
                RadioButton radioButton_usd = (RadioButton)findViewById(R.id.radioButton_usd);
                RadioButton radioButton_gbp = (RadioButton)findViewById(R.id.radioButton_gbp);

               EditText edittext_input= (EditText)findViewById(R.id.editText);
               Double value = 0.0;
                try
                {
                    value = Double.parseDouble(edittext_input.getText().toString());
                }
                catch(Exception e){


                }
                    RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
                    int i =       radioGroup1.getCheckedRadioButtonId();
                    RadioButton btn1 = (RadioButton) radioGroup1.findViewById(i);
                    RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2);
                    int j =       radioGroup2.getCheckedRadioButtonId();
                    RadioButton btn2 = (RadioButton)radioGroup2.findViewById(j);
                    if(btn1.getText().toString().equals("AUD"))
                    {
                        if(btn2.getText().toString().equals("USD")) {
                            value = value * (1 / 1.34);
                        }
                        else if(btn2.getText().toString().equals("GBP"))
                        {
                            value = value * (0.83 / 1.34);
                        }
                    }
                    else if(btn1.getText().toString().equals("CAD"))
                    {
                        if(btn2.getText().toString().equals("USD")) {
                            value = value * (1 / 1.32);
                        }
                        else if(btn2.getText().toString().equals("GBP"))
                        {
                            value = value * (0.83/ 1.32);
                        }
                    }else if(btn1.getText().toString().equals("INR"))
                    {
                        if(btn2.getText().toString().equals("USD")) {
                            value = value * (1 / 68.14);
                        }
                        else if(btn2.getText().toString().equals("GBP"))
                        {
                            value = value * (0.83 / 68.14);
                        }
                    }

                    TextView textview_result = (TextView)findViewById(R.id.textView_result);
                    textview_result.setText(value+"");



            }
        });
    }


    public void clear(View view)
    {
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);

        RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2);
        radioGroup.clearCheck();
        radioGroup2.clearCheck();
        EditText edit_text_input = (EditText) findViewById(R.id.editText);
        edit_text_input.setText("");
        TextView textview_result = (TextView)findViewById(R.id.textView_result);
        textview_result.setText("");

    }


}
