package com.example.android.newsapp;

public class Article {
    private String category;
    private String url;
    private String published;
    private String title;
    private String subtitle;
    private String author;
    private String thumbnail;

    public Article(String category, String url, String published, String title, String subtitle,
                   String author, String thumbnail){

        this.category = category;
        this.url = url;
        this.published = published;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.thumbnail = thumbnail;
    }

    public String getCategory(){
        return category;
    }

    public String getUrl(){
        return url;
    }

    public String getPublished(){
        return published;
    }

    public String getTitle(){
        return title;
    }

    public String getSubtitle(){
        return subtitle;
    }

    public String getAuthor(){
        return author;
    }

    public String getThumbnail(){
        return thumbnail;
    }
}
