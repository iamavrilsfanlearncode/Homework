package com.example.cela.celamovielistview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater myInflater;
    private ArrayList<Movie> movies;
    Button  but_sub,but_story;
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name,txt_Intro,txt_date;
        int position;
        ImageView Pic_1;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            Pic_1 = itemView.findViewById(R.id.Pic1);
            txt_name = itemView.findViewById(R.id.TxtName);
            txt_Intro = itemView.findViewById(R.id.TxtIntro);
            txt_date = itemView.findViewById(R.id.TxtDate);

            but_sub = itemView.findViewById(R.id.ButSubmit);
            but_story = itemView.findViewById(R.id.ButStory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"點選想看的電影",Toast.LENGTH_SHORT).show();
                }
            });
            //確認送出點擊事件
            but_sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                    builder.setTitle("訊息")
                            .setMessage("確定要訂購?")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                //設定確定按鈕
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(itemView.getContext(),"恭喜你成功訂購!",Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                //設定取消按鈕
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).create().show();

                }//OnClick END
            });// 確認送出點擊事件 END

            //詳細資料點擊事件   打包
            but_story.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    Bundle bag = new Bundle();
                    bag.putInt("movie_img", movies.get(position).getMovieImg());
                    bag.putString("movie_name", txt_name.getText().toString());
                    bag.putString("movie_date", txt_date.getText().toString());
                    bag.putString("movie_intro", txt_Intro.getText().toString());
                    intent.putExtras(bag);
                    intent.setClass(view.getContext(),MovieListBig.class);
                    context.startActivity(intent);
                    // 強制轉型
                    //((Activity)context).finish();

                }//OnClick END
            });// 詳細資料點擊事件 END

        } //ViewHolder END
    }//ViewHolder extends RecyclerView.ViewHolder  END
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = myInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override

    //傳值
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Pic_1.setImageResource(movies.get(position).getMovieImg());
        holder.txt_name.setText(movies.get(position).getMovieName());
        holder.txt_Intro.setText(movies.get(position).getMovieIntro());
        holder.txt_date.setText(movies.get(position).getMovieDate());
        holder.position = position;
    }

    @Override
    //抓幾項東西
    public int getItemCount() {
        return movies.size();
    }

    //建構子生成
    public MovieAdapter(Context context,ArrayList<Movie>movies){
        this.context = context;
        this.movies = movies;
    }
}//MovieAdapter  END

    /*舊程式
    //Context
    public MovieAdapter(Context context,ArrayList<Movie>movies){
        this.movies = movies;
        myInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return movies.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View converview, ViewGroup viewGroup) {


        Movie one_movie = (Movie)getItem(i);
        converview = myInflater.inflate(R.layout.item_view,null);//利用inflater連結子畫面layout
        //宣告子畫面中物件對應與id

        ImageView Pic_1 = converview.findViewById(R.id.Pic1);

        TextView txt_name = converview.findViewById(R.id.TxtName);
        TextView txt_Intro = converview.findViewById(R.id.TxtIntro);
        TextView txt_date = converview.findViewById(R.id.TxtDate);
        //設定物件資料來源
        Pic_1.setImageResource(one_movie.getMovieImg());

        txt_name.setText(one_movie.getMovieName());
        txt_Intro.setText(one_movie.getMovieIntro());
        txt_date.setText(one_movie.getMovieDate());


        return converview; //結束


    }


    private class ViewHolder {
    }
      舊程式*/


