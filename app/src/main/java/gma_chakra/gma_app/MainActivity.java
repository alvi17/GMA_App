package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent=new Intent(MainActivity.this,MainMenuClass.class);
//        startActivity(intent);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(MainActivity.this,Disclaimer_Responsibility.class );
                startActivity(i);
                // close this activity
                finish();
            }
        },3000);

    }
}
