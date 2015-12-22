package com.example.joseph.wallpapersetter;

import android.app.Activity;
import android.content.ContextWrapper;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Joseph on 9/5/15.
 */
public class RedditManager
{
    /**
     * JSON Object loaded from Reddit.com/r/<SUBREDDIT>/.json
     */
    private JSONObject redditJSON;

    private String subReddit;

    private final String HOST = "http://reddit.com/";

    private final String JSON_TYPE = "/.json";

    /**
     * Constructor to set custom subReddit
     */
    public RedditManager(String _subReddit)
    {
        subReddit = _subReddit;
    }

    /**
     * Default constructor to set the subReddit to EarthPorn
     */
    public RedditManager()
    {
        subReddit = "EarthPorn";
    }

    /**
     * Public getter method for JSON Object
     * @return redditJSON
     */
    public JSONObject getRedditJson()
    {
        return redditJSON;
    }

    /**
     * Public getter method
     * @return random Url from redditJSON
     */
    public String getRandomUrl()
    {
        String url;
        // TODO: parse Json object
        return url;
    }

    /**
     * Private setter Object - use a HTTP get request using Volley to set JSON Object
     */
    private void setJSONObject() {
        RequestQueue queue = Volley.newRequestQueue(null);
        String url = HOST + subReddit + JSON_TYPE;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>()
            {
                // success callback
                @Override
                public void onResponse(String response)
                {
                    try
                    {
                        // try saving the response
                        redditJSON = new JSONObject(response);
                    }
                    catch (JSONException e)
                    {
                        // error in JSON Conversion
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener()
            {
                // error callback
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    // error in HTTP Request
                    error.printStackTrace();
                }
            });
    }

    private int genRandomInt(int limit)
    {
        int ran = (int) (Math.random() * (limit + 1));
        return ran;
    }
}
