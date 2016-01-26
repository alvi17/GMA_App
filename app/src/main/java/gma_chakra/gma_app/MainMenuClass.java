package gma_chakra.gma_app;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import Adapters.ListAdapter;

/**
 * Created by Alvi17 on 10/14/2015.
 */
public class MainMenuClass extends Activity{
    public static final String MyPreference="daily_on_off";
    public static final String Daily="daily";
    SharedPreferences sharedpreference;
    private PendingIntent pendingIntent;
    ListView list;
    Button exit;
    TextView textView;
    ToggleButton dailyReminder;
    private ScheduleClient scheduleClient;
    int daily_reminder=1;
    int w,h;
    float density;
    String[] options={"Learn About\nYour Master Numbers","Do a\nGrounding Meditation","Light Body Meditation","Platinum Heart Meditation","Balance Your Chakras"
    ,"About\nGrandma Chandra","Resources & Acknowledments"};
    Integer[] images={R.drawable.thumb_masternumbers,R.drawable.thumb_grounding,R.drawable.thumb_lightbody,R.drawable.thumb_platinumheart,R.drawable.thumb_balancechakras
    ,R.drawable.thumb_aboutgrandma,R.drawable.thumb_acknowledgements};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);

        list=(ListView)findViewById(R.id.mainlistView);
        list.setAdapter(new ListAdapter(this, options, images));

        list.setOnItemClickListener(listListener);



//        LinearLayout.LayoutParams parms=(LinearLayout.LayoutParams)list.getLayoutParams();
//        DisplayMetrics dMetrics = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
//        density = dMetrics.density;
//        w = Math.round(dMetrics.widthPixels / density);
//        h = Math.round(dMetrics.heightPixels / density);
//        parms.height=dMetrics.heightPixels-150;
      //  parms.width=dMetrics.widthPixels-20;

      //  list.setLayoutParams(parms);
//        exit=(Button)findViewById(R.id.exit_main_menu_button5);
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainMenuClass.this, Exit_Screen.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        textView=(TextView)findViewById(R.id.deailyRemindertextView);


//        scheduleClient = new ScheduleClient(this);
//        scheduleClient.doBindService();
//        Calendar c = Calendar.getInstance();
//        c.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE));
//        c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY));
//        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE)+10);
//        c.set(Calendar.SECOND, 0);
//        // Ask our service to set an alarm for that date, this activity talks to the client that talks to the service
//        scheduleClient.setAlarmForNotification(c);
        // Notify the user what they just did
 //       Toast.makeText(this, "Notification set for: ",Toast.LENGTH_SHORT).show();


        dailyReminder=(ToggleButton)findViewById(R.id.dailytoggleButton);
        sharedpreference=getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
        if(sharedpreference.contains(Daily))
        {
            daily_reminder=sharedpreference.getInt(Daily,0);

       }
        if(daily_reminder==0)
        {
            dailyReminder.setChecked(false);
        }

        if(dailyReminder.isChecked()==true)
        {
            scheduleNotification(getNotification("Let's have another awakening session today"), 24*60*60*1000,1);
        }
        dailyReminder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sharedpreference.edit();
                if (isChecked) {

                    editor.putInt(Daily,1);
                    scheduleNotification(getNotification("Let's have another awakening session today"), 24*60*60 * 1000, 1);
                }
                else {
                    editor.putInt(Daily,0);
                    scheduleNotification(getNotification("Let's have another awakening session today"),24*60*60*1000,0);
                }
                editor.commit();
            }
        });

    }

    public AdapterView.OnItemClickListener listListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent;

            if(position==0)
            {
                intent=new Intent(MainMenuClass.this,Master_Number_Input.class);
                startActivity(intent);
                finish();
            }
            else if(position==1)
            {
                intent=new Intent(MainMenuClass.this,Grounding_Meditation.class);
                startActivity(intent);

                finish();
            }
            else if(position==2)
            {
                intent=new Intent(MainMenuClass.this,Light_Body_Meditation.class);
                startActivity(intent);
                finish();
            }
            else if(position==3)
            {
                intent=new Intent(MainMenuClass.this,Platinum_Heart_Meditation.class);
                startActivity(intent);
                finish();
            }
            else if(position==4)
            {
                intent=new Intent(MainMenuClass.this,Chakra_Balance_Settings.class);
                startActivity(intent);
                finish();
            }
            else if(position==5)
            {
                intent=new Intent(MainMenuClass.this,About_Grandma_Chandra.class);
                startActivity(intent);
                finish();
            }
            else if(position==6)
            {
                intent=new Intent(MainMenuClass.this,Ack_Resources.class);
                startActivity(intent);
                finish();
            }

        }
    };


    private void scheduleNotification(Notification notification, int delay,int on_off) {

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        notificationIntent.putExtra("On_Off",on_off);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Grandma Chandra App");
        builder.setContentText(content);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        return builder.build();
    }

}
