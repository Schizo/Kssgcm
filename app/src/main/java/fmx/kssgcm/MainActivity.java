package fmx.kssgcm;


import android.content.Intent;
import android.media.MediaCodec;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;



import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.VideoSurfaceView;
import com.google.android.exoplayer.source.DefaultSampleSource;
import com.google.android.exoplayer.source.FrameworkSampleExtractor;

public class MainActivity extends ActionBarActivity  {

    private VideoSurfaceView surfaceView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        surfaceView = (VideoSurfaceView)findViewById(R.id.surface_view);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new GcmRegistrationAsyncTask(this).execute();




        Uri uri = Uri.parse("http://html5demos.com/assets/dizzy.mp4");
        final int numRenderers = 2;


        // Build the sample source
        DefaultSampleSource sampleSource =
                new DefaultSampleSource(new FrameworkSampleExtractor(this, uri, null), 2);

        // Build the track renderers
        TrackRenderer videoRenderer = new MediaCodecVideoTrackRenderer(sampleSource, MediaCodec.VIDEO_SCALING_MODE_SCALE_TO_FIT);
        TrackRenderer audioRenderer = new MediaCodecAudioTrackRenderer(sampleSource);

        // Build the ExoPlayer and start playback
        ExoPlayer exoPlayer = ExoPlayer.Factory.newInstance(numRenderers);
        exoPlayer.prepare(videoRenderer, audioRenderer);

        // Pass the surface to the video renderer.
        exoPlayer.sendMessage(videoRenderer, MediaCodecVideoTrackRenderer.MSG_SET_SURFACE, surfaceView);

        exoPlayer.setPlayWhenReady(true);


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
