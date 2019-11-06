package com.example.dsphim2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;

    public DownLoadImage(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String urls = strings[0];
        Bitmap result = null;
        try {
            URL url = new URL(urls);
            URLConnection connection = url.openConnection();
            connection.setUseCaches(true);
            InputStream in = url.openStream();
            result = BitmapFactory.decodeStream(in);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}