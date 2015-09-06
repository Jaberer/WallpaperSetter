package com.example.joseph.wallpapersetter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.net.URI;
import java.net.URISyntaxException;

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
        // get imageView
        ImageView imageView = (ImageView) getView().findViewById(R.id.imageView);
        try {
            imageView.setImageBitmap(new ImageLoader("http://i.imgur.com/2HPGDdJ.jpg", imageView).doInBackground());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page,
                container, false);
        return rootView;
    }
}
