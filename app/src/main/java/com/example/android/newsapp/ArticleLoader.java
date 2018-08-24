package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.example.android.newsapp.util.QueryUtils;

import java.util.List;

import static com.example.android.newsapp.NewsActivity.LOG_TAG;

public class ArticleLoader extends AsyncTaskLoader<List<Article>>{

    /** Query URL */
    private String url;

    /**
     * Constructs a new {@link ArticleLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public ArticleLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "Loader on start (Loader)");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Article> loadInBackground() {
        Log.i(LOG_TAG, "Loader on background (Loader");
        if (url == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of articles.
        List<Article> articles = QueryUtils.fetchArticleData(url);
        return articles;
    }
}
