package com.mjo.misioncba.section.feedback.stepTwo;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by jucastillo on 11/1/17.
 */
public class PostDataTask extends AsyncTask<String, Void, Boolean> {

    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    private OnPostTaskListener listener;
    public static final String URL="https://docs.google.com/forms/d/e/1FAIpQLSfd9tvaG7wUUuImeyhR-R7qgYde1QEObfLFr3BZnKSLkeDgEg/formResponse";


    public PostDataTask(OnPostTaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected Boolean doInBackground(String... contactData) {
        Boolean result = true;

        String postBody = contactData[0];

        try{
            //Create OkHttpClient for sending request
            OkHttpClient client = new OkHttpClient();
            //Create the request body with the help of Media Type
            RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
            Request request = new Request.Builder()
                    .url(URL)
                    .post(body)
                    .build();
            //Send the request
            Response response = client.newCall(request).execute();
        }catch (IOException exception){
            result=false;
        }
        return result;
    }

    @Override
    protected void onPostExecute(Boolean result){
        if(this.listener != null){
            if(result){
                this.listener.onPostTaskSuccess();
            }else{
                this.listener.onPostTaskError();
            }
        }
    }


    public interface OnPostTaskListener {

        void onPostTaskSuccess();

        void onPostTaskError();
    }
}
