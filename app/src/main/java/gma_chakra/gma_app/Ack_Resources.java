package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by Alvi17 on 10/15/2015.
 */
public class Ack_Resources extends Activity{
    ScrollView scrollView;
    int w,h;
    float density;
    Button mainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ack_resources);
        scrollView=(ScrollView)findViewById(R.id.ackScroll);
        LinearLayout.LayoutParams parms=(LinearLayout.LayoutParams)scrollView.getLayoutParams();
        DisplayMetrics dMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
        density = dMetrics.density;
        w = Math.round(dMetrics.widthPixels / density);
        h = Math.round(dMetrics.heightPixels / density);
        parms.height=dMetrics.heightPixels-Math.round(150*density);
   //     scrollView.setLayoutParams(parms);

        mainMenu=(Button)findViewById(R.id.ack_main_button5);

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Ack_Resources.this,MainMenuClass.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
