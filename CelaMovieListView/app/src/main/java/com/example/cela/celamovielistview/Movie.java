package com.example.cela.celamovielistview;

public class Movie {
    /*MovieName 電影名稱
        MovieDate 上映日期
        MovieIntro 電影簡介
        MovieImg電影圖*/
    int MovieImg;
    String MovieName;
    String MovieDate;
    String MovieIntro;

    //右鍵Generate  Constrator

    public Movie(int movieImg, String movieName, String movieDate, String movieIntro) {
        MovieImg = movieImg;
        MovieName = movieName;
        MovieDate = movieDate;
        MovieIntro = movieIntro;
        }

    //右鍵Generate  Getter and Setter


    public int getMovieImg() {
        return MovieImg;
    }

    public void setMovieImg(int movieImg) {
        MovieImg = movieImg;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getMovieDate() {
        return MovieDate;
    }

    public void setMovieDate(String movieDate) {
        MovieDate = movieDate;
    }

    public String getMovieIntro() {
        return MovieIntro;
    }

    public void setMovieIntro(String movieIntro) {
        MovieIntro = movieIntro;
    }
}