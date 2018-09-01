package android.curso.samsungchallenge;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnCreate, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.buttonCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent createUserActivity = new Intent(MainActivity.this, CreateUserActivity.class);
                 MainActivity.this.startActivity(createUserActivity);
            }
        });

        btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeNavigationActivity = new Intent(MainActivity.this, HomeNavigationActivity.class);
                MainActivity.this.startActivity(homeNavigationActivity);
            }
        });

    }
}
