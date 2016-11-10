package com.wimso.androidloginandregistration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wimso.androidloginandregistration.model.BaseResponse;
import com.wimso.androidloginandregistration.network.RegisterService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private EditText firstnameText;
    private EditText lastnameText;
    private EditText emailText;
    private EditText passwordText;

    private Button btnRegister;

    private RegisterService registerService;

    public static void start(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        firstnameText = (EditText) findViewById(R.id.firstname);
        lastnameText = (EditText) findViewById(R.id.lastname);
        emailText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        btnRegister = (Button) findViewById(R.id.btn_register);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAct();
            }
        });
    }

    void registerAct() {
        String firstname = firstnameText.getText().toString();
        String lastname = lastnameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if(TextUtils.isEmpty(firstname)) {
            firstnameText.setError("Firstname cannot be empty !");
            return;
        }

        if(TextUtils.isEmpty(lastname)) {
            firstnameText.setError("Lastname cannot be empty !");
            return;
        }

        if(TextUtils.isEmpty(email)) {
            firstnameText.setError("Email cannot be empty !");
            return;
        }

        if(TextUtils.isEmpty(password)) {
            firstnameText.setError("Password cannot be empty !");
            return;
        }

        registerService = new RegisterService(this);
        registerService.doRegister(firstname, lastname, email, password, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                BaseResponse baseResponse = (BaseResponse) response.body();

                if(baseResponse != null) {
                    if(!baseResponse.isError()) {
                        LoginActivity.start(RegisterActivity.this);
                        RegisterActivity.this.finish();
                    }

                    Toast.makeText(RegisterActivity.this, baseResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "An error occurred!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
