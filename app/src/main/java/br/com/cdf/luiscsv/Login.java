package br.com.cdf.luiscsv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity  implements View.OnClickListener {

    ImageButton ibLogin;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ibLogin = (ImageButton)findViewById(R.id.ibLogin);
        ibLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case(R.id.ibLogin):
                startActivity(new Intent(this,MainActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
