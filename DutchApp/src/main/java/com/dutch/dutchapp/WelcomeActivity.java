package com.dutch.dutchapp;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends BaseActivity {

    //UI References
    private TextView mBrandView;
    private View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextView mVersion = (TextView) findViewById(R.id.text_version);
//        mVersion.setText(getVersion());
        setContentView(R.layout.activity_welcome);

        mBrandView = (TextView) findViewById(R.id.text_brand);
        mLoginFormView = findViewById(R.id.login_form);

        // Move Brand up
        mBrandView.animate()
                .translationYBy(-300f)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(500)
                .setStartDelay(2000)
                .start();

        // Display login form
        mLoginFormView.animate()
                .alpha(1f)
                .setDuration(500)
                .start();
//        mLoginFormView.setVisibility(View.VISIBLE);


        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);*/

    }


}
