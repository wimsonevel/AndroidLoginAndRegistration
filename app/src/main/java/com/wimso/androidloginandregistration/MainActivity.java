package com.wimso.androidloginandregistration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wimso.androidloginandregistration.model.User;
import com.wimso.androidloginandregistration.util.PrefUtil;

public class MainActivity extends AppCompatActivity {

    private TextView greeting;
    private TextView email;
    private Button btnLogout;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greeting = (TextView) findViewById(R.id.greeting);
        email = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        User user = PrefUtil.getUser(this, PrefUtil.USER_SESSION);

        greeting.setText(getResources().getString(R.string.greeting, user.getData().getFirstname()));
        email.setText(user.getData().getEmail());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutAct();

                LoginActivity.start(MainActivity.this);
                MainActivity.this.finish();
            }
        });

    }

    void logoutAct() {
        PrefUtil.clear(this);
    }
}
