package com.example.user.beginner;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtTim1,
            edtTim2;
    Button btnGo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Input Team");
        //getSupportActionBar().setSubtitle("My apps");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        btnGo = (Button)findViewById(R.id.btn_go);

        edtTim1 = (EditText)findViewById(R.id.edt_tim_1);
        edtTim2 = (EditText)findViewById(R.id.edt_tim_2);


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(edtTim1.getText()) || TextUtils.isEmpty(edtTim2.getText())){
                    Toast.makeText(getApplicationContext(), "Nama Tim belum terisi", Toast.LENGTH_SHORT).show();
                }else{
                    String tim1 = edtTim1.getText().toString();
                    String tim2 = edtTim2.getText().toString();

                    Intent intent = new Intent(getApplicationContext(), ScoreboardActivity.class);
                    intent.putExtra("tim1",tim1);
                    intent.putExtra("tim2",tim2);
                    startActivity(intent);

                    edtTim1.setText("");
                    edtTim2.setText("");
                }
            }
        });
    }
}
