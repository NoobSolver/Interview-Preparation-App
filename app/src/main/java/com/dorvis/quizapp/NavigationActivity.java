package com.dorvis.quizapp;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.dorvis.quizapp.activities.AboutUsActivity;
import com.dorvis.quizapp.subactivities.ToDoNotificationActivity;
import com.dorvis.quizapp.technews.NewsActivity;
import com.dorvis.quizapp.fragments.FirstHomeFragment;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.io.File;
/*
 created by Sainath Hiwale
 */

public class NavigationActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "NavigationActivity";
    private static final int SELECT_PHOTO = 100;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    ImageView imageView;
    android.app.FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    //nav_header navigation view item
    ImageView profile_imgView;
    TextView username_txtview;
    // header.xml action bar item
    ImageView signin_img;
    TextView textViewName;

    //navigation menu floder
    ImageView imageView_navsend;
    ImageView imageView_navNotification;

   //nav_header_navigation UI

    ImageView PhotoImageview;
    TextView EmailTextView;
    TextView UserNameTextview;
    //home fragment imageview
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);



       initViews();


       GoogleSignInOptions  gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
              .requestEmail()
               .build();

       googleApiClient = new GoogleApiClient.Builder(this)
               .enableAutoManage(this,this)
               .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
               .build();





        FragmentManager manager = this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new FirstHomeFragment()).commit();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        mNavigationView.removeHeaderView(null);

        mNavigationView.removeHeaderView(mNavigationView.getHeaderView(0));
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_navigation,null);
        PhotoImageview = (ImageView)header.findViewById(R.id.imageView_profile);
        EmailTextView =(TextView)header.findViewById(R.id.userName_txtview);
        UserNameTextview =(TextView)header.findViewById(R.id.display_usertxView);
        mNavigationView.addHeaderView(header);


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                int id = item.getItemId();
                if (id == R.id.nav_sign_out) {
                    logOut();
                    finish();

                } else if (id == R.id.nav_tech_news) {
                    startActivity(new Intent(NavigationActivity.this, NewsActivity.class));

                } else if (id == R.id.nav_notification) {
                    startActivity(new Intent(getApplicationContext(), ToDoNotificationActivity.class));

                    //  Toast.makeText(NavigationActivity.this,"Coming soon...",Toast.LENGTH_SHORT).show();

                }  else if (id == R.id.nav_share){
                    showAlertDialog();

                } else if (id == R.id.nav_send){
                    showContactUsDialog();
                } else if (id == R.id.nav_aboutus){
                    startActivity(new Intent(getApplicationContext(),AboutUsActivity.class));
                }else if (id == R.id.nav_exit){
                    exitApplicationAlertDialog();
                }else if (id == R.id.nav_likeus){

                    Toast.makeText(NavigationActivity.this,"Coming soon",Toast.LENGTH_SHORT).show();
                }



                return false;
            }
        });



       Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


    }


    private void exitApplicationAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Are you sure")
                .setMessage("You want to colse the app..")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NavigationActivity.this.finish();
                    }
                }).setNegativeButton("No", null)
                .show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult  <GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()){
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);


        }else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });

        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            EmailTextView.setText(account.getEmail());
            UserNameTextview.setText(account.getGivenName());
            Glide.with(this).load(account.getPhotoUrl()).into(PhotoImageview);


        }else {
            goLoginScreen();
        }




    }

    private void goLoginScreen() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void logOut(){
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()){
                    goLoginScreen();
                }else {
                    Toast.makeText(getApplicationContext(),R.string.not_close_session,Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }



    private void showAlertDialog() {
      new AlertDialog.Builder(this)
              .setMessage("Choose action for share this app...")
              .setPositiveButton("BLUETOOTH", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      shareApplicationByBluetooth();
                  }
              }).setNegativeButton("OTHERS", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              shareApplicationByShareit();

          }
      }).create().show();

    }

    private void shareApplicationByShareit() {
        PackageManager pm = getApplicationContext().getPackageManager();
        ApplicationInfo appInfo;
        try{
             appInfo = pm.getApplicationInfo(getApplicationContext().getPackageName(),PackageManager.GET_META_DATA);
             Intent sendBt = new Intent(Intent.ACTION_SEND);
             sendBt.setType("*/*");
            sendBt.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(appInfo.publicSourceDir)));
            sendBt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(Intent.createChooser(sendBt, "Share it using"));

        }catch (PackageManager.NameNotFoundException e1){
            e1.printStackTrace();
        }
    }

    private void shareApplicationByBluetooth() {
        try {
            ApplicationInfo app = getApplicationContext().getApplicationInfo();
            String filepath = app.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.setPackage("com.android.bluetooth");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filepath)));
            startActivity(Intent.createChooser(intent,"Share app"));
            Toast.makeText(getApplicationContext(),"Share the Programming quiz by bluetooth ", Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void initViews(){
        //signin_img = (ImageView) findViewById(R.id.header_signin);
        username_txtview = (TextView) findViewById(R.id.userName_txtview);
        profile_imgView = (ImageView) findViewById(R.id.imageView_profile);
        imageView_navsend =(ImageView)findViewById(R.id.nav_send);
        imageView_navNotification =(ImageView)findViewById(R.id.nav_notification);

    }
    private void showContactUsDialog() {
        new AlertDialog.Builder(this)
                .setMessage("For any queries contact this email \n sainathhiwale5@gmail.com")
                .setPositiveButton("send email", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:sainathhiwale5@gmail.com")));
                    }
                }).create().show();

           }


}
