package android.curso.samsungchallenge.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.controller.UserController;
import android.curso.samsungchallenge.model.User;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnCreate, btnLogin;
    EditText editTextLoginEmail, editTextLoginPassword;
    SharedPreferences sharedPreferences;

    public boolean validateLoginUserEmail() {
        String userEmail = editTextLoginEmail.getText().toString().trim();
        if (userEmail.isEmpty()) {
            editTextLoginEmail.setError("Informe um e-mail");
            return false;
        }
        editTextLoginEmail.setError(null);
        return true;
    }

    public boolean validateLoginUserPassword() {
        String userPassword = editTextLoginPassword.getText().toString().trim();
        if (userPassword.isEmpty()) {
            editTextLoginPassword.setError("Informe uma senha");
            return false;
        }
        editTextLoginPassword.setError(null);
        return true;
    }

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

        editTextLoginEmail = (EditText) findViewById(R.id.editTextLoginEmail);
        editTextLoginPassword = (EditText) findViewById(R.id.editTextLoginPassword);

        btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateLoginUserEmail() == true && validateLoginUserPassword()) {
                    User obj = new User();
                    obj.setEmail(editTextLoginEmail.getText().toString().trim());
                    obj.setPassword(editTextLoginPassword.getText().toString().trim());
                    UserController userController = new UserController(getBaseContext());
                    if (userController.userExists(obj) == 1) {
                        Toast.makeText(getBaseContext(), "Bem-vindo" , Toast.LENGTH_SHORT ).show();
                        Intent homeNavigationActivity = new Intent(MainActivity.this, HomeNavigationActivity.class);
                        MainActivity.this.startActivity(homeNavigationActivity);
                    } else {
                        Toast.makeText(getBaseContext(), "Dados incorretos" , Toast.LENGTH_SHORT ).show();
                    }

                }
            }
        });

    }
}
