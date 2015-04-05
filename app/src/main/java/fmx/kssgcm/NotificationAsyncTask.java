package fmx.kssgcm;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.fmx.myapplication.backend.registration.Registration;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fmx on 02.04.15.
 */
public class NotificationAsyncTask extends AsyncTask<Void, Void, String> {

    private Context context;


    public NotificationAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {



        Logger.getLogger("WOHOO").log(Level.INFO, "wizz");


        return "nothing";
    }

    @Override
    protected void onPostExecute(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        Logger.getLogger("REGISTRATION").log(Level.INFO, msg);


    }
}