package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Alvi17 on 10/15/2015.
 */
public class Chakra_Balance extends Activity{
    Button b1,b2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chakra_balancing);

        b1=(Button)findViewById(R.id.choose_chakrabutton);
        b2=(Button)findViewById(R.id.chakra_balance_main_button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Chakra_Balance.this,Chakra_Balance_Settings.class);
                startActivity(intent);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Chakra_Balance.this,MainMenuClass.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
