package android.curso.samsungchallenge.view;

import android.content.Intent;
import android.curso.samsungchallenge.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity {

    Button btnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        btnNewUser = findViewById(R.id.buttonNewUser);
        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Tudo certo no seu cadastro!" , Toast.LENGTH_SHORT ).show();
                Intent createNewUserActivity = new Intent(CreateUserActivity.this, MainActivity.class);
                CreateUserActivity.this.startActivity(createNewUserActivity);
            }
        });
    }
}
