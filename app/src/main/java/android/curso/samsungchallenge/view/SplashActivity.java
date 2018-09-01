package android.curso.samsungchallenge.view;

import android.content.Intent;
import android.curso.samsungchallenge.R;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        showSplashScreen();
    }

    private void showSplashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginView = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(loginView);
            }
        }, SPLASH_TIME_OUT);
    }
}
