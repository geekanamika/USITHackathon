package com.example.android.hackathon;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE;

public class Translate extends AppCompatActivity {
    String url="https://translation.googleapis.com/language/translate/v2?key=AIzaSyBE_7O4Xv__eWSrBCtWtA1UF6aIocQWPw8";
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json");
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        toPost test = new toPost();
        test.execute();
        Toast.makeText(getApplicationContext(),"grr",Toast.LENGTH_LONG).show();
//
    }

    private class toPost extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... params) {
            HttpURLConnection conn = null;
            try {
                URL url = new URL("https://translation.googleapis.com/language/translate/v2?key=AIzaSyBE_7O4Xv__eWSrBCtWtA1UF6aIocQWPw8");
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                String body = "q=hello&target=de";
                OutputStream output = new BufferedOutputStream(conn.getOutputStream());
                output.write(body.getBytes());
                output.flush();

                //This is needed
                // Could alternatively use conn.getResponseMessage() or conn.getInputStream()
                conn.getResponseCode();
                Toast.makeText(getApplicationContext(),"gr",Toast.LENGTH_LONG).show();

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                conn.disconnect();
            }
            return null;
        }

    }
    


}
