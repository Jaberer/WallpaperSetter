package com.example.joseph.wallpapersetter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Joseph on 9/5/15.
 */
public class ImageLoader extends AsyncTask<Void, Void, Bitmap>
{
    private String url;
    private ImageView imageView;

    public ImageLoader(String _url, ImageView _imageView)
    {
        url = _url;
        imageView = _imageView;
    }

    @Override
    protected Bitmap doInBackground(Void... params)
    {
        try
        {
            // connect to URL
            URL urlConnection = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
            connection.setDoInput(true);
            connection.connect();

            // get input
            InputStream input = connection.getInputStream();
            Bitmap mBitmap = BitmapFactory.decodeStream(input);
            return mBitmap;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result)
    {
        super.onPostExecute(result);
        imageView.setImageBitmap(result);
    }
}
