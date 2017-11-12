package com.example.user.beginner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HasilActivity extends AppCompatActivity {

    TextView txtHasil;
    RadioGroup radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtHasil = (TextView)findViewById(R.id.txt_hasil);

        Intent intent = getIntent();

        String content = intent.getStringExtra("hasilPertandingan");
        int x = 0;

        if (content.equals("seri")){
            txtHasil.setText("Pertandingan Seri");
        }else{
            txtHasil.setText("The Winner is " + content);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
