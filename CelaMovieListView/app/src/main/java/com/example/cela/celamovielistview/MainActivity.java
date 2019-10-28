package com.example.cela.celamovielistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView list_View;

    Intent intent;
    public MovieAdapter adapter = null;
    public ArrayList<Movie> movieList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_View = findViewById(R.id.movieList);
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie
                (R.drawable.bee,"神鬼認證：傑森包恩","2016-07-25","麥特戴蒙強勢回歸他最具代表性的主角傑森包恩..."));
        movieList.add(new Movie
                (R.drawable.bookshop,"街角的書店","2016-07-26","芙洛倫絲因為先生去世，決定為自己實現長久以來的夢想：開一間書店。最後來到英國濱海的寧靜小鎮哈博洛，展開她追逐夢想的新生活。芙洛倫絲買下了一間荒廢許久的破舊老屋，經營起鎮上唯一的書店。\n"));
        movieList.add(new Movie
                (R.drawable.champion,"最酷的一天","2016-07-27","以莫札特作為人生目標，卻苦無成名契機的古怪鋼琴家小安（馬提亞斯史維克福 飾..."));
        movieList.add(new Movie
                (R.drawable.summer,"夏日情事","2016-07-25","莎夏在柏林意外離世，讓男友勞倫斯與柔伊兩人頓失了一位情人和一位姊姊..."));
        movieList.add(new Movie
                (R.drawable.hades,"變裝皇后萬萬歲","2016-07-25","★2016台北電影節 ★2016美國奧斯卡獎最佳外語片提名決選.."));
        adapter = new MovieAdapter(MainActivity.this, movieList);

        //實驗
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list_View.setLayoutManager(layoutManager);
        list_View.setAdapter(adapter);
        //實驗 END


    }


 }

