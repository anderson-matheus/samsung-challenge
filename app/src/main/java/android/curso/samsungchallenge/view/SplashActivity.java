package android.curso.samsungchallenge.view;

import android.content.Intent;
import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.datasource.DataSource;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_splash);


        showSplashScreen();
    }

    private void showSplashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DataSource ds = new DataSource(getBaseContext());
                Intent loginView = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(loginView);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
