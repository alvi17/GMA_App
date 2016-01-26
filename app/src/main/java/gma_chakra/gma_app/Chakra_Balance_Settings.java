package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by Alvi17 on 10/15/2015.
 */
public class Chakra_Balance_Settings extends Activity{
    public static final String MyPreference="sound_on_off";
    public static final String Sound="sound";
    Spinner chakraSpinner,timeSpinner;
    int chakra_id=0;
    int time_vlaue=0;
    Button selectChakra;
    SharedPreferences sharedpreference;
    ToggleButton soundButton;
    TextView soundText;
    int sound_on_off=1;
    Intent intent;
    Button mainMenu,backButton,protocol;
    FrameLayout fm;
    int w,h;
    float density;
    ImageButton img;
    String[] time={"1 Minute","3 Minute","5 Minute","Quantum Time"};
    String[] charksa={"All Chakras","Root Chakra","Sacral Chakra","Solar Plexus","Heart Chakra","Throat Chakra","Third Eye Chakra","Crown Chakra","Soul Star Chakra","All- Quantum Rotation"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chakra_balance_settings);
        fm=(FrameLayout)findViewById(R.id.chakra_settings_frame);

//        LinearLayout.LayoutParams parms=(LinearLayout.LayoutParams)fm.getLayoutParams();
//        DisplayMetrics dMetrics = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
//        density = dMetrics.density;
//        w = Math.round(dMetrics.widthPixels / density);
//        h = Math.round(dMetrics.heightPixels / density);
//        parms.height=dMetrics.heightPixels-Math.round(300*density);
//        fm.setLayoutParams(parms);

        chakraSpinner=(Spinner)findViewById(R.id.chakraSpinner);
        timeSpinner=(Spinner)findViewById(R.id.chakratimeSpinner);

        soundButton=(ToggleButton)findViewById(R.id.soundtoggleButton);
        soundText=(TextView)findViewById(R.id.sound_on_off_textView7);
    //    mainMenu=(Button)findViewById(R.id.chakra_settings_mainmeu);
        backButton=(Button)findViewById(R.id.charka_settings_back);
      //  img=(ImageButton)findViewById(R.id.spinnerimageButton);
        protocol=(Button)findViewById(R.id.protocolbutton);
     //   chakraSpinner.setBackgroundColor(Color.argb(50,50,50,50));
//        mainMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Chakra_Balance_Settings.this,MainMenuClass.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Chakra_Balance_Settings.this,MainMenuClass.class);
                startActivity(intent);
                finish();
            }
        });


        sharedpreference=getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
        if(sharedpreference.contains(Sound))
        {
            sound_on_off=sharedpreference.getInt(Sound,0);

        }
        if(sound_on_off==1)
        {
            soundButton.setChecked(true);
        }
        else {
            soundButton.setChecked(false);
        }
  //    Toast.makeText(getApplicationContext(), "Sound settings " + sound_on_off, Toast.LENGTH_LONG).show();
        ArrayAdapter<String> timeAdapter=new ArrayAdapter<String>(this,R.layout.spinner_item,time);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);
        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time_vlaue = position + 1;
                SharedPreferences.Editor editor = sharedpreference.edit();
                editor.putInt("Time", time_vlaue);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                time_vlaue =  1;
                SharedPreferences.Editor editor = sharedpreference.edit();
                editor.putInt("Time", time_vlaue);
                editor.commit();
            }
        });

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item, charksa);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chakraSpinner.setAdapter(dataAdapter);
        chakraSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chakra_id = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

      //  selectChakra=(Button)findViewById(R.id.select_chakra_button);

        protocol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (chakra_id == 1) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_Details.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();
                } else if (chakra_id == 2) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_Details.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();

                } else if (chakra_id == 3) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_details_2.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();
                } else if (chakra_id == 4) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_details_3.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                } else if (chakra_id == 5) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_details_4.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();
                } else if (chakra_id == 6) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_details_5.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();
                } else if (chakra_id == 7) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_details_6.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();
                } else if (chakra_id == 8) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_details_7.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();
                } else if (chakra_id == 9) {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_details_8.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();
                }
                else if(chakra_id==10)
                {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_Details.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    intent = new Intent(Chakra_Balance_Settings.this, Crystal_Details.class);
                    intent.putExtra("Position", chakra_id);
                    intent.putExtra("Time",time_vlaue);
                    startActivity(intent);
                    finish();
                }

            }
        });

        soundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sharedpreference.edit();
                if (isChecked) {
                    soundText.setText("Sound On");
                    editor.putInt(Sound, 1);
                } else {
                    soundText.setText("Sound Off");
                    editor.putInt(Sound, 0);
                }
                editor.commit();
            }
        });


    }
}
