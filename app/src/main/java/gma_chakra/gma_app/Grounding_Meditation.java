package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alvi17 on 10/13/2015.
 */

public class Grounding_Meditation extends Activity{
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    public  int oneTimeOnly;
    ImageButton pauseButton;
    MediaPlayer mediaPlayer;
    TextView start,end;
    Button mainMenu;
    int w,h;
    float density;
    PowerManager.WakeLock wakeLock;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.grounding_meditation);

     //   PowerManager powerManager = (PowerManager)this.getSystemService(Context.POWER_SERVICE);
       // wakeLock = powerManager.newWakeLock(PowerManager.FLAG_KEEP_SCREEN_ON, "My Lock");

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        LinearLayout l1=(LinearLayout)findViewById(R.id.grounding_ll);
        LinearLayout.LayoutParams parms=(LinearLayout.LayoutParams)l1.getLayoutParams();

        DisplayMetrics dMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
        density = dMetrics.density;
        w = Math.round(dMetrics.widthPixels / density);
        h = Math.round(dMetrics.heightPixels / density);
        parms.height=dMetrics.heightPixels/2+65;

       // l1.setLayoutParams(parms);
        oneTimeOnly = 0;

        seekbar=(SeekBar)findViewById(R.id.seekBar1);
        start=(TextView)findViewById(R.id.startAudio);
        end=(TextView)findViewById(R.id.end_audio_textView);
        mainMenu=(Button)findViewById(R.id.ground_main_button);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                Intent intent=new Intent(Grounding_Meditation.this,MainMenuClass.class);
                startActivity(intent);
                finish();
            }
        });
        mediaPlayer=MediaPlayer.create(this,R.raw.grounding_medi);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setVolume(1, 1);
        mediaPlayer.start();
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        pauseButton=(ImageButton)findViewById(R.id.pause_imageButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    pauseButton.setImageResource(R.drawable.ic_media_play);
                }
                else
                {
                    mediaPlayer.start();
                    pauseButton.setImageResource(R.drawable.ic_media_pause);
                }
            }
        });


        seekbar.setMax((int) finalTime);



        end.setText(String.format("%d:%d",5,47)
        );

        start.setText(String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
        );

        seekbar.setProgress((int) startTime);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        myHandler.postDelayed(UpdateSongTime, 100);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                pauseButton.setImageResource(R.drawable.ic_media_play);
                start.setText(String.format("%d:%d",
                                5,47)
                );
            }
        });

    }
    private Runnable UpdateSongTime = new Runnable() {
        public void run(){
            startTime = mediaPlayer.getCurrentPosition();
            if(seekbar.getProgress()==(int)finalTime)
            {
                pauseButton.setImageResource(R.drawable.ic_media_play);
            }

            start.setText(String.format("%d:%d",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) startTime)))
            );

           // finalTime=mediaPlayer.getCurrentPosition();
//            end.setText(String.format("-%d:%d",
//                            TimeUnit.MILLISECONDS.toMinutes((long) finalTime) - TimeUnit.MILLISECONDS.toMinutes((long) startTime),
//                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
//                                            toMinutes((long) startTime)))
//            );
            seekbar.setProgress((int) startTime);

            myHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
        }
       // wakeLock.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
      //  wakeLock.acquire();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Grounding_Meditation.this,MainMenuClass.class);
        startActivity(i);
        finish();
    }
}
