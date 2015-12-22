package com.example.joseph.wallpapersetter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScreenSlidePageFragment extends Fragment {

    /**
     * RedditManager to handle getting and querying images
     */
    private RedditManager redditManager;

    /**
     * Handle View Creation
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page,
                container, false);

        // get imageView
        //ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageView);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        AQuery androidAQuery = new AQuery(rootView);
        androidAQuery.ajax("http://i.imgur.com/AmWThvw.jpg", Bitmap.class, 0, new AjaxCallback<Bitmap>() {
            @Override
            public void callback(String url, Bitmap bitmap, AjaxStatus status)
            {
                super.callback(url, bitmap, status);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
                imageView.setImageBitmap(bitmap);
            }
        });
        //androidAQuery.id(imageView).image(YOUR IMAGE TO LOAD, true, true, getDeviceWidth(), ANY DEFAULT IMAGE YOU WANT TO SHOW);

        try {
            //imageView.setImageBitmap(getBitmapFromUrl("http://i.imgur.com/2HPGDdJ.jpg"));
            //Picasso.with(getActivity().getApplicationContext()).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
    }

    public static Bitmap getBitmapFromUrl(String _url)
    {
        try
        {
            // connect to url
            URL url = new URL(_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();

            // get input
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            // TODO: 9/6/15 - use a static default Bitmap...or an array
            return null;
        }
    }
}
