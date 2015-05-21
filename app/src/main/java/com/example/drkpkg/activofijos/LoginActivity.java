package com.example.drkpkg.activofijos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void callReaderActivityAfterButton(View view){
        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode, data);

        if (scanResult != null) {
            String content = scanResult.getContents();
            RequestParams params = new RequestParams();
            params.add("userId","891");
            params.add("id","234");
            params.add("title","Prueba a la mierda");
            params.add("body","Patito patito color de cafe");

            safRestful.get("/posts/1", null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    Log.i("OBJECT: ", response.toString());
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    Log.i("ARRAY:", response.toString());
                    //Toast.makeText(getApplication(),"Yay",Toast.LENGTH_LONG).show();
                    // Pull out the first event on the public timeline
                    //JSONObject firstEvent = timeline.get(0);
                    //String tweetText = firstEvent.getString("text");
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    //super.onFailure(statusCode, headers, responseString, throwable);
                    Log.i("ERROR: ", responseString);
                    Toast.makeText(getApplication(), "Se fue a la mierda", Toast.LENGTH_LONG).show();
                }

            });

            /*safRestful.post("/posts", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            Log.i("OBJECT: ", response.toString());
                        }

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                            Log.i("ARRAY:", response.toString());
                            //Toast.makeText(getApplication(),"Yay",Toast.LENGTH_LONG).show();
                            // Pull out the first event on the public timeline
                            //JSONObject firstEvent = timeline.get(0);
                            //String tweetText = firstEvent.getString("text");
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                            //super.onFailure(statusCode, headers, responseString, throwable);
                            Log.i("ERROR: ", responseString);
                            Toast.makeText(getApplication(),"Se fue a la mierda",Toast.LENGTH_LONG).show();
                        }
                    }
            );*/

        }
    }
}
