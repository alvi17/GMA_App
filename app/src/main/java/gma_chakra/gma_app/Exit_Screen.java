package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Alvi17 on 10/15/2015.
 */
public class Exit_Screen extends Activity{
    Button exit,main_menu;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_screen);
        exit=(Button)findViewById(R.id.exitbutton5);
        main_menu=(Button)findViewById(R.id.exit_main_menu_button4);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Exit_Screen.this,MainMenuClass.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
