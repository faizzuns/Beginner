package com.example.user.beginner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtHasil = (TextView)findViewById(R.id.txt_hasil);

        Intent intent = getIntent();
        int score1 = intent.getIntExtra("score1",0);
        int score2 = intent.getIntExtra("score2",0);
        String namaTim1 = intent.getStringExtra("namaTim1");
        String namaTim2 = intent.getStringExtra("namaTim2");

        String content;

        if (score1 > score2){
            content = "THE WINNER IS "+namaTim1;
        }else if (score2>score1){
            content = "THE WINNER IS "+namaTim2;
        }else{
            content = "DRAW";
        }

        txtHasil.setText(content);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
