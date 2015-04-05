package fmx.kssgcm;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;

import com.google.android.exoplayer.ExoPlayer;

public class MainActivity extends ActionBarActivity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new GcmRegistrationAsyncTask(this).execute();

        //player = ExoPlayer.Factory.newInstance(RENDERER_COUNT);

       /* Intent i = new Intent(Intent.ACTION_VIEW);
        i.setPackage("com.mxtech.videoplayer.ad");
        i.setDataAndType(Uri.parse("http://www.example.com"), "video/h264");
        startActivity(i);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
