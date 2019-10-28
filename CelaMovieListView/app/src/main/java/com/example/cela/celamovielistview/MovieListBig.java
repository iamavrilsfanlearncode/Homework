package com.example.cela.celamovielistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieListBig extends AppCompatActivity {
    Intent intent;
    Bundle bag;
    Button btn_previous;
    TextView list_View;
    int MovieImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemview_big);
        list_View = findViewById(R.id.movieList);
        btn_previous = findViewById(R.id.Butprvious);

        //使用bundle接收資料+setText
        bag = getIntent().getExtras();
        int MovieImg = bag.getInt("movie_img");
        ImageView Pic2 = findViewById(R.id.Pic2);
        Pic2.setImageResource(MovieImg);
        TextView tvTxtName = findViewById(R.id.TxtName);
        tvTxtName.setText(bag.getString("movie_name"));
        TextView tvDate = findViewById(R.id.TxtDate);
        tvDate.setText(bag.getString("movie_date"));
        TextView tvIntro = findViewById(R.id.TxtIntro);
        tvIntro.setText(bag.getString("movie_intro"));



        btn_previous = findViewById(R.id.Butprvious);
        //回到上一頁OnClickListener 開始
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                                Intent intent = new Intent();
                                //回到MainActivity, this主要Activity  ; class 下一個Activity
                                intent.setClass(MovieListBig.this,MainActivity.class);
                                startActivity(intent);
                                 */
                finish();//先暫停專案的工作, btnPrevious執行setOnClickListener
            }
        });//回到上一頁 END





    }
}
