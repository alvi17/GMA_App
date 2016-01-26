package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Alvi17 on 10/15/2015.
 */
public class About_Grandma_Chandra extends Activity{

    Button sendEmail,mainMenu,website;

    String s="";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_grandma_chandra);

        sendEmail=(Button)findViewById(R.id.email_button);
        mainMenu=(Button)findViewById(R.id.main_button_about);
        website=(Button)findViewById(R.id.website_button);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.grandmachandra.com/chandra"));
                startActivity(browserIntent);
            }
        });
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_Grandma_Chandra.this,MainMenuClass.class);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void sendEmail() {


        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","grandmachandra@grandmachandra.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }


}
