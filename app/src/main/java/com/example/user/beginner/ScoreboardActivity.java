package com.example.user.beginner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreboardActivity extends AppCompatActivity {

    TextView namaTim1
            ,namaTim2
            ,scoreTim1
            ,scoreTim2;
    Button btnTwoPointTim1
            ,btnTwoPointTim2
            ,btnThreePointTim1
            ,btnThreePointTim2
            ,btnSelesai;

    int score1 = 0;
    int score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisasi variabel
        namaTim1= (TextView)findViewById(R.id.nama_tim_1);
        namaTim2 = (TextView)findViewById(R.id.nama_tim_2);
        scoreTim1= (TextView)findViewById(R.id.score_tim_1);
        scoreTim2 = (TextView)findViewById(R.id.score_tim_2);
        btnTwoPointTim1 = (Button)findViewById(R.id.two_point_tim_1);
        btnTwoPointTim2 = (Button)findViewById(R.id.two_point_tim_2);
        btnThreePointTim1 = (Button)findViewById(R.id.three_point_tim_1);
        btnThreePointTim2 = (Button)findViewById(R.id.three_point_tim_2);
        btnSelesai = (Button)findViewById(R.id.btn_selesai);

        Intent intent = getIntent();
        final String tim1 = intent.getStringExtra("tim1");
        final String tim2 = intent.getStringExtra("tim2");

        //setting nama tim
        namaTim1.setText(tim1);
        namaTim2.setText(tim2);

        //setting point tim 1
        btnTwoPointTim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 = score1 +2;
                scoreTim1.setText(String.valueOf(score1));
            }
        });
        btnThreePointTim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 = score1 +3;
                scoreTim1.setText(String.valueOf(score1));
            }
        });

        //setting tim 2
        btnTwoPointTim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2 = score2 + 2;
                scoreTim2.setText(String.valueOf(score2));
            }
        });
        btnThreePointTim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2 = score2 + 3;
                scoreTim2.setText(String.valueOf(score2));
            }
        });

        //setting selesai
        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HasilActivity.class);
                intent.putExtra("score1",score1);
                intent.putExtra("score2",score2);
                intent.putExtra("namaTim1",tim1);
                intent.putExtra("namaTim2",tim2);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()== android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
