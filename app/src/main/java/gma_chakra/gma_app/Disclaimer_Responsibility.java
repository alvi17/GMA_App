package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Alvi17 on 10/15/2015.
 */
public class Disclaimer_Responsibility extends Activity implements View.OnClickListener{
    Button accept,reject,back;
    TextView text;
    ScrollView scrollView;
    int w,h;
    float density;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms_condition);

        scrollView=(ScrollView)findViewById(R.id.scroll_terms);
        LinearLayout.LayoutParams parms=(LinearLayout.LayoutParams)scrollView.getLayoutParams();
        DisplayMetrics dMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
        density = dMetrics.density;
        w = Math.round(dMetrics.widthPixels / density);
        h = Math.round(dMetrics.heightPixels / density);
        parms.height=dMetrics.heightPixels-Math.round(160*density);
      //  scrollView.setLayoutParams(parms);

        text=(TextView)findViewById(R.id.term_conditiontextView);
        text.setText(getResources().getString(R.string.terms_condition).replace("+",""));

        accept=(Button)findViewById(R.id.acceptbutton);
        reject=(Button)findViewById(R.id.rejectbutton);
        back=(Button)findViewById(R.id.termback_button);

        accept.setOnClickListener(this);
        reject.setOnClickListener(this);
        back.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent intent;
        switch (id)
        {
            case R.id.acceptbutton:
                intent=new Intent(Disclaimer_Responsibility.this,Login.class);
                startActivity(intent);
                finish();
                break;
            case R.id.rejectbutton:
                finish();
                break;
            case R.id.termback_button:
                intent=new Intent(Disclaimer_Responsibility.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;

        }

    }
}
