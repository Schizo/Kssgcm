package fmx.kssgcm;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.exoplayer.VideoSurfaceView;

public class MainActivity extends ActionBarActivity  {

    private VideoSurfaceView surfaceView;
//    private Button okButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        surfaceView = (VideoSurfaceView)findViewById(R.id.surface_view);
//        okButton = (Button)findViewById(R.id.paint);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = getIntent();
        new GcmRegistrationAsyncTask(this).execute();
//
//
//
//
//        Uri uri = Uri.parse("http://html5demos.com/assets/dizzy.mp4");
//        final int numRenderers = 2;
//
//
//        // Build the sample source
//        DefaultSampleSource sampleSource =
//                new DefaultSampleSource(new FrameworkSampleExtractor(this, uri, null), 2);
//
//        // Build the track renderers
//        TrackRenderer videoRenderer = new MediaCodecVideoTrackRenderer(sampleSource, MediaCodec.VIDEO_SCALING_MODE_SCALE_TO_FIT);
//        TrackRenderer audioRenderer = new MediaCodecAudioTrackRenderer(sampleSource);
//
//        // Build the ExoPlayer and start playback
//        ExoPlayer exoPlayer = ExoPlayer.Factory.newInstance(numRenderers);
//        exoPlayer.prepare(videoRenderer, audioRenderer);
//
//        // Pass the surface to the video renderer.
//        exoPlayer.sendMessage(videoRenderer, MediaCodecVideoTrackRenderer.MSG_SET_SURFACE, surfaceView);
//
//        exoPlayer.setPlayWhenReady(true);


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

    public void startPlayerIntent(View v) {
        tToast("Starting Player Intent");
        Intent mpdIntent = new Intent(this, PlayerActivity.class)
                .setData(Uri.parse("http://html5demos.com/assets/dizzy.mp4"))
                .putExtra(PlayerActivity.CONTENT_ID_EXTRA, "")
                .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, DemoUtil.TYPE_OTHER);
        startActivity(mpdIntent);
    }

    public void goButtonClicked(View v) {
        tToast("Go button clicked!");
        Intent intent = new Intent(this, FingerPaint.class);
        startActivity(intent);
    }

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }
}
