package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
//import com.udacity.gradle.builditbigger.backend.MyEndpoint;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by ravikiranpathade on 12/3/17.
 */

public class EndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>[] pairs) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)

                    .setRootUrl("https://gradle-android.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
            Log.d("Check", "Context");
            context = pairs[0].first;
            String name = pairs[0].second;
            try {
                return myApiService.sayHi().execute().getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    Toast toast;

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (context != null) {
            if (toast != null) {
                toast.cancel();
            }
            Toast.makeText(context, s, Toast.LENGTH_LONG).show();
        }
    }
}
