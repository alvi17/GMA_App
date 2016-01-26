package gma_chakra.gma_app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Alvi17 on 10/12/2015.
 */
public class Crystal_Details extends Activity implements View.OnClickListener{
    public static final String MyPreference="sound_on_off";
    public static final String Sound="sound";
    ImageView chakra_flower,chakra_crystal;
    Button back,next,mainmeu;
    TextView chakraName,chakraDetails;
    int id=0;
    String[] titles;
    String[] descriptions;
    SharedPreferences sharedpreference;
    int sound_on_off=1;
    int time=1;
    MediaPlayer mediaPlayer;
    int w,h;
    float density;
    SeekBar seekbar;
    CountDownTimer cntr_aCounter;
    LinearLayout l1,l2,l3;
    int i=0;
    ImageView img;
    Dialog currentDialog;
    DisplayMetrics dMetrics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chakra_info_1);
        img=(ImageView)findViewById(R.id.imageView_ck1);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showCrystal();

            }
        });




        id=getIntent().getIntExtra("Position", 0);
        sharedpreference=getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
     //   time=getIntent().getIntExtra("Time",0);

        seekbar=(SeekBar)findViewById(R.id.ck1_seekbar);
        if(sharedpreference.contains(Sound))
        {
            sound_on_off = sharedpreference.getInt(Sound,0);
        }

        if(sharedpreference.contains("Time"))
        {
            time=sharedpreference.getInt("Time",0);
        }
     //   Toast.makeText(getApplicationContext(), "Sound +time" + time*60+" ID: "+id, Toast.LENGTH_LONG).show();
        seekbar.setMax(time*60);
        titles=getResources().getStringArray(R.array.chakra_title);
        descriptions=getResources().getStringArray(R.array.chakra_details);



        back=(Button)findViewById(R.id.back_button1);
        next=(Button)findViewById(R.id.nextbutton1);
        mainmeu=(Button)findViewById(R.id.main_menubutton1);

//        l1=(LinearLayout)findViewById(R.id.ck1_first);
//        l2=(LinearLayout)findViewById(R.id.ck1_second);
//        l3=(LinearLayout)findViewById(R.id.ck1_text);
//
//        LinearLayout.LayoutParams parms=(LinearLayout.LayoutParams)l1.getLayoutParams();
//        LinearLayout.LayoutParams parms1=(LinearLayout.LayoutParams)l2.getLayoutParams();
//        LinearLayout.LayoutParams parms3=(LinearLayout.LayoutParams)l3.getLayoutParams();
//        dMetrics = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
//        density = dMetrics.density;
//        w = Math.round(dMetrics.widthPixels / density);
//        h = Math.round(dMetrics.heightPixels / density);
//        parms.height=dMetrics.heightPixels/2-40;
//        parms.width=dMetrics.widthPixels-10;
      //  l1.setLayoutParams(parms);

     //   parms1.height=dMetrics.heightPixels/2-90;
     //   parms1.width=dMetrics.widthPixels/2-10;
    //    l2.setLayoutParams(parms1);

    //    parms3.height=dMetrics.heightPixels/3-20;
    //    parms3.width=dMetrics.widthPixels/2-10;
    //    l3.setLayoutParams(parms3);

        back.setOnClickListener(this);
        next.setOnClickListener(this);
        mainmeu.setOnClickListener(this);

        if(sound_on_off==1) {

            mediaPlayer = MediaPlayer.create(this, R.raw.chakra1);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setVolume(1, 1);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            int t=0;
            if(time!=0)
            {
                    if(time!=4)
                    {
                         t=time*60000;
                    }

                    else
                    {
                        t=mediaPlayer.getDuration();
                        mediaPlayer.setLooping(false);
                //        Toast.makeText(getApplicationContext(),"Time: " +t,Toast.LENGTH_LONG).show();
                    }

                    cntr_aCounter = new CountDownTimer(t,1000) {
                    public void onTick(long millisUntilFinished) {
                        i++;
                        int progress= i/2;
                        seekbar.setProgress(progress);
                    }

                    public void onFinish() {
                        //code fire after finish
                        mediaPlayer.stop();
                        seekbar.setProgress(seekbar.getMax());

                        if(id==10 || id==1)
                        {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // This method will be executed once the timer is over
                                    // Start your app main activity
                                   // Toast.makeText(getApplicationContext(), "IN Handler  ID: "+id, Toast.LENGTH_LONG).show();
                                }
                            }, 1000);

                            Intent i = new Intent(Crystal_Details.this,Crystal_details_2.class );
                            i.putExtra("Position", id);
                            startActivity(i);
                            // close this activity
                            finish();
                        }
                    }
                };
                cntr_aCounter.start();
            }
            else
            {
                mediaPlayer.start();
            }
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId())
        {
            case R.id.nextbutton1:
             //   id=(id+1)%9;
                if(sound_on_off==1) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                }
                intent=new Intent(Crystal_Details.this,Crystal_details_2.class);
                startActivity(intent);
                finish();
                break;
            case R.id.back_button1:
             //   id=(id+8)%9;
                if(sound_on_off==1) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                }
                intent=new Intent(Crystal_Details.this,Chakra_Balance_Settings.class);
                startActivity(intent);
                finish();
                break;
            case R.id.main_menubutton1:
                if(sound_on_off==1) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                }
                intent=new Intent(Crystal_Details.this,MainMenuClass.class);
                startActivity(intent);
                finish();
                break;


        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sound_on_off==1) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            cntr_aCounter.cancel();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        if(sound_on_off==1) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
            cntr_aCounter.start();
        }



    }



    public void showCrystal()
    {
        currentDialog=new Dialog(this);
        currentDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        currentDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        currentDialog.setContentView(R.layout.color_dialog);

      //  ImageView bigImage=(ImageView)currentDialog.findViewById(R.id.bigImage);

        LinearLayout ll=(LinearLayout)currentDialog.findViewById(R.id.dialog_layout);
        LinearLayout bigImage=(LinearLayout)currentDialog.findViewById(R.id.bigImage_layout);

      //  LinearLayout.LayoutParams parm=(LinearLayout.LayoutParams)ll.getLayoutParams();
       // parm.height=dMetrics.heightPixels/2+150;
     //   parm.width=dMetrics.widthPixels-100;

      //  ll.setLayoutParams(parm);
        bigImage.setBackgroundResource(R.drawable.chakracrystal1);

        Button close=(Button)currentDialog.findViewById(R.id.closeButton);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDialog.dismiss();
            }
        });

        currentDialog.setCancelable(true);
        currentDialog.show();
    }
}
