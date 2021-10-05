package com.example.randomquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


import android.view.View;

import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends AppCompatActivity {

    // creating variables for our textview,
    // imageview,cardview and progressbar.
    private TextView quoteTV,headTV;
    private ProgressBar loadingPB;
    private Button newBtn;

    // below line is the variable for url from
    // where we will be querying our data.
    String quoteUrl = "https://api.quotable.io/random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // in below line we are initializing our all views.
        loadingPB = findViewById(R.id.idLoadingPB);
        quoteTV = findViewById(R.id.quoteTV);
        newBtn = findViewById(R.id.newQuoteBtn);
        headTV = findViewById(R.id.headTV);
        newBtn.setVisibility(View.INVISIBLE);
        headTV.setSelected(true);
        quoteTV.setVisibility(View.INVISIBLE);
        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        // as our data is in json object format so we are using
        // json object request to make data request from our url.
        // in below line we are making a json object
        // request and creating a new json object request.
        // inside our json object request we are calling a
        // method to get the data, "url" from where we are
        // calling our data,"null" as we are not passing any data.
        // later on we are calling response listener method
        // to get the response from our API.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, quoteUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // inside the on response method.
                // we are hiding our progress bar.
                loadingPB.setVisibility(View.GONE);
                newBtn.setVisibility(View.VISIBLE);
                quoteTV.setVisibility(View.VISIBLE);
                // in below line we are making our card
                // view visible after we get all the data.
//                courseCV.setVisibility(View.VISIBLE);
                try {
                    // now we get our response from API in json object format.
                    // in below line we are extracting a string with its key
                    // value from our json object.
//                    // similarly we are extracting all the strings from our json object.
                    String quote = response.getString("content");
                    // after extracting all the data we are
                    // setting that data to all our views.
                        quoteTV.setText(quote);

                } catch (JSONException e) {
                    // if we do not extract data from json object properly.
                    // below line of code is use to handle json exception
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            // this is the error listener method which
            // we will call if we get any error from API.
            @Override
            public void onErrorResponse(VolleyError error) {
                // below line is use to display a toast message along with our error.
                Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        // at last we are adding our json
        // object request to our request
        // queue to fetch all the json data.
        queue.add(jsonObjectRequest);
    }

    public void getNewQuote(View view) {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest jsonObjectNewRequest = new JsonObjectRequest(Request.Method.GET, quoteUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // inside the on response method.
                // we are hiding our progress bar.
                loadingPB.setVisibility(View.GONE);

                // in below line we are making our card
                // view visible after we get all the data.
//                courseCV.setVisibility(View.VISIBLE);
                try {
                    // now we get our response from API in json object format.
                    // in below line we are extracting a string with its key
                    // value from our json object.
//                    // similarly we are extracting all the strings from our json object.
                    String quote = response.getString("content");
                    // after extracting all the data we are
                    // setting that data to all our views.
                    quoteTV.setText(quote);

                } catch (JSONException e) {
                    // if we do not extract data from json object properly.
                    // below line of code is use to handle json exception
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            // this is the error listener method which
            // we will call if we get any error from API.
            @Override
            public void onErrorResponse(VolleyError error) {
                // below line is use to display a toast message along with our error.
                Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectNewRequest);
    }

}
