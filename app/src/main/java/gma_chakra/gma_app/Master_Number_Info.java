package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Alvi17 on 10/17/2015.
 */
public class Master_Number_Info extends Activity{
    ScrollView scrollView;
    int w,h;
    float density;
    Button mainMenu,backButton;
    String s;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_number_info);
        s=getIntent().getStringExtra("Master");
        scrollView=(ScrollView)findViewById(R.id.master_scrollView);


        t1=(TextView)findViewById(R.id.master_number1);
        t2=(TextView)findViewById(R.id.master_number2);
        t3=(TextView)findViewById(R.id.master_number3);
        t4=(TextView)findViewById(R.id.master_number4);
        t5=(TextView)findViewById(R.id.master_number5);
        t6=(TextView)findViewById(R.id.master_number6);
        t7=(TextView)findViewById(R.id.master_number7);
        t8=(TextView)findViewById(R.id.master_number8);
        t9=(TextView)findViewById(R.id.master_number9);

        if(s.contains("11"))
        {
            t1.setBackgroundColor(Color.argb(50,50,50,50));
        }
        if(s.contains("22"))
        {
            t2.setBackgroundColor(Color.argb(50,50,50,50));
        }
        if(s.contains("33"))
        {
            t3.setBackgroundColor(Color.argb(50,50,50,50));
        }
        if(s.contains("44"))
        {
            t4.setBackgroundColor(Color.argb(50,50,50,50));
        }
        if(s.contains("55"))
        {
            t5.setBackgroundColor(Color.argb(50,50,50,50));
        }
        if(s.contains("66"))
        {
            t6.setBackgroundColor(Color.argb(50,50,50,50));
        }
        if(s.contains("77"))
        {
            t7.setBackgroundColor(Color.argb(50,50,50,50));
        }
        if(s.contains("88"))
        {
            t8.setBackgroundColor(Color.argb(50,50,50,50));
        }
        if(s.contains("99"))
        {
            t9.setBackgroundColor(Color.argb(50,50,50,50));
        }

        if(s.equals("There is no master number in your Birthday"))
        {
            Toast.makeText(getApplicationContext(),"There is no master number in your Birthday",Toast.LENGTH_LONG).show();
        }
        else if(s.length()>0 && !s.equals("There is no master number in your Birthday"))
        {
            Toast.makeText(getApplicationContext(),"Your Master Number(s): "+s,Toast.LENGTH_LONG).show();
        }

     //   mainMenu=(Button)findViewById(R.id.master_info_main_button6);
        backButton=(Button)findViewById(R.id.master_info_back_button5);
//
//        mainMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//                public void onClick(View v) {
//                Intent intent=new Intent(Master_Number_Info.this,MainMenuClass.class);
//                startActivity(intent);
//                finish();
//                }
//        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Master_Number_Info.this,Master_Number_Input.class);
                startActivity(intent1);
                finish();
            }
        });



    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Master_Number_Info.this,Master_Number_Input.class);
        startActivity(intent);
        finish();
    }
}
