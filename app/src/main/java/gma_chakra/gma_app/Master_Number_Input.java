package gma_chakra.gma_app;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Alvi17 on 10/15/2015.
 */
public class Master_Number_Input extends Activity{

    Button birtday_input;
    Button mainMenu,nextButton;
    TextView birthday,masterNumber;
    private Dialog currentDialog;
    private int year;
    private int month;
    private int day;
    String master_numbers;
    static final int DATE_DIALOG_ID = 999;
    ImageView img;
    int w,h;
    float density;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_number_birthday);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        birtday_input=(Button)findViewById(R.id.select_birthday);
        birtday_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
                //   showDatePicker();
            }
        });




        master_numbers="";
        mainMenu=(Button)findViewById(R.id.master_main_menu_button5);
        nextButton=(Button)findViewById(R.id.master_next_button6);

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Master_Number_Input.this,MainMenuClass.class);
                startActivity(intent);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Master_Number_Input.this,Master_Number_Info.class);
                intent1.putExtra("Master",s);
                startActivity(intent1);
                finish();
            }
        });


       // birthday=(TextView)findViewById(R.id.master_birthday_textView);
        masterNumber=(TextView)findViewById(R.id.master_number_textView);

        img=(ImageView)findViewById(R.id.imageView_calculate_chakra);
        LinearLayout.LayoutParams parms=(LinearLayout.LayoutParams)img.getLayoutParams();
        DisplayMetrics dMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
        density = dMetrics.density;
        w = Math.round(dMetrics.widthPixels / density);
        h = Math.round(dMetrics.heightPixels / density);
        parms.height=dMetrics.heightPixels/3+20;
        parms.width=dMetrics.widthPixels-20;

        img.setLayoutParams(parms);



    }


    public void showDatePicker()
    {
        currentDialog=new Dialog(this);
        currentDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        currentDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        currentDialog.setContentView(R.layout.master_date_picker);

        currentDialog.setCancelable(true);

        final DatePicker datePicker=(DatePicker)currentDialog.findViewById(R.id.datePicker);
        datePicker.init(year,month,day,null);

        final Button selcet=(Button)currentDialog.findViewById(R.id.select_birthday_dialog_button);



    }
    String s="";
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            birtday_input.setText(new StringBuilder().append(month + 1)
                    .append("/").append(day).append("/").append(year)
                    .append(" "));
            s="";
            Calculate_Master_Number();

            birtday_input.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(Master_Number_Input.this,Master_Number_Info.class);
                    intent1.putExtra("Master",s);
                    startActivity(intent1);
                    finish();
                }
            });
            // set selected date into datepicker also


        }
    };


    public void Calculate_Master_Number()
    {
        int temp_year=year;
        int y1=temp_year%10;
        temp_year=temp_year/10;
        int y2=temp_year%10;
        temp_year=temp_year/10;
        int y3=temp_year%10;
        temp_year=temp_year/10;
        int y4=temp_year%10;

        int temp_date=day;
        int d1=temp_date%10;
        temp_date=temp_date/10;
        int d2=temp_date%10;

        int temp_month=month+1;
        int m1=temp_month%10;
        temp_month=temp_month/10;
        int m2=temp_month%10;

      //  Toast.makeText(getApplicationContext(), y1+" "+y2+" "+y3+" "+y4+" "+d1+" "+d2 +" "+m1+" "+m2, Toast.LENGTH_SHORT).show();
        int list[]=new int[11];

        int original=0;
        for(int i=0;i<11;i++)
        {
            list[i]=0;
        }
        for(int i=1;i<10;i++)
        {
            if(y1==i)
            {
                list[i]+=1;

            }
            if(y2==i)
            {
                list[i]+=1;
            }
            if(y3==i)
            {
                list[i]+=1;
            }
            if(y4==i)
            {
                list[i]+=1;
            }
            if(d1==i)
            {
                list[i]+=1;
            }
            if(d2==i)
            {
                list[i]+=1;
            }
            if(m1==i)
            {
                list[i]+=1;
            }
            if(m2==i)
            {
                list[i]+=1;
            }

        }


        for(int i=1;i<10;i++)
        {
            if(list[i]>=2)
            {
                original=1;
            }
        }



        if(original==1) {
            for (int i = 1; i < 10; i++) {
                if (list[i] >= 2) {
                    if(!s.contains(i+""+i)) {
                        s += i + "" + i + " ";
                    }
                }
            }
        }
        else
        {

            ArrayList<Integer> values=new ArrayList<Integer>();
            values.add(y1);
            values.add(y2);
            values.add(y3);
            values.add(y4);
            values.add(m1);
            values.add(m2);
            values.add(d1);
            values.add(d2);


            List<List<String>> allSubsets = powerSet(values, 0);
            for (List<String> subsets : allSubsets) {
                int sum=0;
             //   s+=subsets+" ";
                if(subsets.size()>1) {
                    for (int i = 0; i < subsets.size(); i=i+2){
                     //   s+=subsets.get(i)+" ";
                        sum+=Integer.parseInt(subsets.get(i));
                    }
                }
                if(sum==11)
                {
                    s+="11 ";
                    original=2;
                }
                if(sum==22)
                {
                    s+="22 ";
                    original=2;
                }
                if(sum==33)
                {
                    s+="33 ";
                    original=2;
                }
                if(sum==44)
                {
                    s+="44 ";
                    original=2;
                }
            }
        }

    //    Toast.makeText(getApplicationContext(),original+" ",Toast.LENGTH_LONG).show();
        if(original==0)
        {
            s="There is no master number in your Birthday";
        }
        masterNumber.setText(s);

        masterNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Master_Number_Input.this,Master_Number_Info.class);
                intent1.putExtra("Master",s);
                startActivity(intent1);
                finish();
            }
        });
        //add up the numbers

    }

    public List<List<String>> powerSet( List<Integer> values,
                                               int index) {
        if (index == values.size()) {
            return new ArrayList<>();
        }
        int val = values.get(index);
        List<List<String>> subset = powerSet(values, index + 1);
        List<List<String>> returnList = new ArrayList<>();
        returnList.add(Arrays.asList(String.valueOf(val)));
        returnList.addAll(subset);
        for (final List<String> subsetValues : subset) {
            for (final String subsetValue : subsetValues) {
                returnList.add(Arrays.asList(val + "," + subsetValue));
            }
        }
        return returnList;
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Master_Number_Input.this,MainMenuClass.class);
        startActivity(intent);
        finish();
    }
}
