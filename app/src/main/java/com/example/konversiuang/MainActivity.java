package com.example.konversiuang;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    TextView teks1,teks2;
    RadioButton dkr,rkd;
    Button konversi;
    RadioGroup grupu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teks1 = (TextView)findViewById(R.id.teks1);
        teks2 = (TextView)findViewById(R.id.teks2);
        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        dkr = (RadioButton)findViewById(R.id.dkr);
        rkd = (RadioButton)findViewById(R.id.rkd);
        grupu = (RadioGroup)findViewById(R.id.grupu);
        konversi = (Button)findViewById(R.id.konversi);

        grupu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (dkr.isChecked()){
                    teks1.setText("Dollar");
                    teks2.setText("Rupiah");
                    edit1.setText("");
                    edit2.setText("");
                    Toast.makeText(MainActivity.this, "Dollar Ke Rupiah", Toast.LENGTH_SHORT).show();
                }
                else{
                    teks1.setText("Rupiah");
                    teks2.setText("Dollar");
                    edit1.setText("");
                    edit2.setText("");
                    Toast.makeText(MainActivity.this, "Rupiah Ke Dollar", Toast.LENGTH_SHORT).show();
                }
            }
        });


        konversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (dkr.isChecked()){
                   double dollar = Double.parseDouble(edit1.getText().toString());
                   double rumus = dollar*13000;
                   edit2.setText(String.valueOf(rumus));
               }
               else {
                   double rupiah = Double.parseDouble(edit1.getText().toString());
                   double rumus = rupiah/13000;
                   edit2.setText(String.valueOf(rumus));
               }
            }
        });
    }
}
