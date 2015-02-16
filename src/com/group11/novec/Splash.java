package com.group11.novec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

	private static int SPLASH_TIME_OUT = 3000;
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
 
        new Handler().postDelayed(new Runnable() {
 
            public void run() {
                
                Intent i = new Intent(Splash.this, Categories.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}