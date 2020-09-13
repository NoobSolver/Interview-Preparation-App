package com.dorvis.quizapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;


public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "LoginActivity";
    private  GoogleApiClient googleApiClient;
    private SignInButton signInButton;

    public static final int SIGN_IN_CODE =777;
    private boolean back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

      signInButton =(SignInButton)findViewById(R.id.google_sign_in_button);


      signInButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
              startActivityForResult(intent,777);
          }
      });


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

       // Log.d(TAG, "onConnectionFailed:" + connectionResult);
        Toast.makeText(this,"onConnectionFailed",Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 777){
           GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);

        }
    }

    private void handleSignInResult(GoogleSignInResult result) {

          if (result.isSuccess()){
              Toast.makeText(this,"Login Successfully",Toast.LENGTH_SHORT).show();

              getMainScreen();

          }else {

              Toast.makeText(this,"Connect to Internet",Toast.LENGTH_SHORT).show();

          }


    }


    private void getMainScreen() {

        Intent intent = new Intent(this,NavigationActivity.class);
        startActivity(intent);
        finish();
    }



}