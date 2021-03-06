package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
//    String s="";
    public static final String Username="username5";
    public static final String Password="password5";
    SharedPreferences sharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreference=getSharedPreferences("Login5", Context.MODE_PRIVATE);

   //     Intent i = new Intent(MainActivity.this, Ack_Resources.class);
    //    startActivity(i);
//        Intent intent=new Intent(MainActivity.this,MainMenuClass.class);
//        startActivity(intent);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                // This method will be executed once the timer is over
                // Start your app main activity
                if(sharedpreference.contains(Username) && sharedpreference.contains(Password))
                {
                    Intent i = new Intent(MainActivity.this,MainMenuClass.class );
                    startActivity(i);
                    finish();
                }
                else {
                    Intent i = new Intent(MainActivity.this, Disclaimer_Responsibility.class);
                    startActivity(i);
                    finish();
                }
            }
            // close this activity
        },3000);

    }
}
