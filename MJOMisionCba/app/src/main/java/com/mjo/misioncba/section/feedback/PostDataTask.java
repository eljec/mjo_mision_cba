package com.mjo.misioncba.section.feedback;

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

    private Context ctx;

    public static final String URL="https://docs.google.com/forms/d/e/1FAIpQLSdmstJH8tE-JDAFNuc_pRiazD93AgNoCP2n4U979-6r84Ht3g/formResponse";

    @Override
    protected Boolean doInBackground(String... contactData) {
        Boolean result = true;
        String comida = contactData[0];
        String sugerencia = contactData[1];
        String postBody="";

        try {
            //all values must be URL encoded to make sure that special characters like & | ",etc.
            //do not cause problems
            postBody = "entry.1811832601"+"=" + URLEncoder.encode(comida,"UTF-8") +
                    "&" + "entry.1136129796" + "=" + URLEncoder.encode(sugerencia,"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            result=false;
        }

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
        //Print Success or failure message accordingly
        Toast.makeText(ctx,result?"Message successfully sent!":"There was some error in sending message. Please try again after some time.",Toast.LENGTH_LONG).show();
    }
}
