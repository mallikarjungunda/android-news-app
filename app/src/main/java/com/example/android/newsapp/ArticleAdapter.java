package com.example.android.newsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import static com.example.android.newsapp.NewsActivity.LOG_TAG;

public class ArticleAdapter extends ArrayAdapter<Article>{

    Context context;

    public ArticleAdapter(Context context, ArrayList<Article> appArticles) {
        super(context,0, appArticles);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        ViewHolder holder = new ViewHolder();
        Article currentArticle = getItem(position);

        if(null == holder.titleTextView) {
            holder.titleTextView = (TextView) listItemView.findViewById(R.id.title_text);
        }
        String title = currentArticle.getTitle().replaceAll("<.*?>", "");
        holder.titleTextView.setText(title);

        if(null == holder.authorTextView) {
            holder.authorTextView = (TextView) listItemView.findViewById(R.id.author_text);
        }
        String author = currentArticle.getAuthor().replaceAll("<.*?>", "");
        holder.authorTextView.setText(author);

        if(null == holder.publishedTextView) {
            holder.publishedTextView = (TextView) listItemView.findViewById(R.id.date_text);
        }
        String published = currentArticle.getPublished().replaceAll("<.*?>", "");
        String splitDateAt = "T";
        String date = published;
        if(published.contains(splitDateAt)){
            String[] sections = published.split(splitDateAt);
            date = sections[0];
            Log.v(LOG_TAG, "Article published at: " + date);
        }
        holder.publishedTextView.setText(date);
        if(null == holder.subtitleTextView){
            holder.subtitleTextView = (TextView) listItemView.findViewById(R.id.subtitle_text);
        }

        String subtitle = currentArticle.getSubtitle().replaceAll("<.*?>", "");
        holder.subtitleTextView.setText(subtitle);

        if(null == holder.categoryTextView) {
            holder.categoryTextView = (TextView) listItemView.findViewById(R.id.category_text);
        }
        String category = currentArticle.getCategory().replaceAll("<.*?>", "");
        holder.categoryTextView.setText(category);

        if(null == holder.thumbnailImageView){
            holder.thumbnailImageView = (ImageView) listItemView.findViewById(R.id.thumbnail_image);
        }
        String thumbnail = currentArticle.getThumbnail();
        if(thumbnail.length() != 0) {
            Picasso.with(context).load(thumbnail).resize(90, 90).centerCrop().placeholder(R.drawable.noimage)
                    .error(R.drawable.noimage).into(holder.thumbnailImageView);
        } else {
            holder.thumbnailImageView.setImageResource(R.drawable.noimage);
        }

        return listItemView;
    }


    static class ViewHolder {
        TextView titleTextView;
        TextView authorTextView;
        TextView publishedTextView;
        TextView subtitleTextView;
        TextView categoryTextView;
        ImageView thumbnailImageView;
    }
}
