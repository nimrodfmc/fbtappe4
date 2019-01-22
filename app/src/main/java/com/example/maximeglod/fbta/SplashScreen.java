package com.example.maximeglod.fbta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;



public class SplashScreen extends Activity {
   private static int SPLASH_TIME_OUT = 3000;
   protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_splash);
      new android.os.Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent i = new Intent(SplashScreen.this, MainActivity.class);
              startActivity(i);
              finish();
          }

      }, SPLASH_TIME_OUT);
   }
}
