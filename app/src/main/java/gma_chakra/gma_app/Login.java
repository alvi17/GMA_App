package gma_chakra.gma_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Alvi17 on 10/15/2015.
 */
public class Login extends Activity implements View.OnClickListener{
    public static final String Login="Login";
    public static final String Username="username";
    public static final String Password="password";
    public static final String id_="id";
    Button login;
    EditText username,password;
    SharedPreferences sharedpreference;
    int index=0;
    String user="",pass="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        sharedpreference=getSharedPreferences(Login, Context.MODE_PRIVATE);
        if(sharedpreference.contains(id_))
        {
            index=sharedpreference.getInt(id_,0);
        }
        if(sharedpreference.contains(Username))
        {
            user=sharedpreference.getString(Username,"");
        }
        if(sharedpreference.contains(Password))
        {
            pass=sharedpreference.getString(Password,"");
        }
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);

        login=(Button)findViewById(R.id.loginbutton);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent intent;
        if(sharedpreference.contains(id_))
        {
            index=sharedpreference.getInt(id_,0);
        }
        switch (id)
        {
            case R.id.loginbutton:
                if(index==0)
                {
                    SharedPreferences.Editor editor=sharedpreference.edit();
                    editor.putInt(id_, 1);
                    editor.putString(Username,username.getText().toString());
                    editor.putString(Password, password.getText().toString());
                    editor.commit();
                    intent = new Intent(Login.this, MainMenuClass.class);
                    startActivity(intent);
                    finish();
                }

                else {
                    if(!user.equals(username.getText().toString())&& !pass.equals(password.getText().toString()))
                    {

                        Toast.makeText(getApplicationContext(),"In Valid Login.\nPlease Try Again\n"+"User name:"+ user +" Password: "+pass
                                ,Toast.LENGTH_LONG).show();
                    }
                    else {
                        intent = new Intent(Login.this, MainMenuClass.class);
                        startActivity(intent);
                        finish();
                    }
                }
                break;
        }


    }
}
