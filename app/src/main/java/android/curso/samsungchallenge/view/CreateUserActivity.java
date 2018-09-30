package android.curso.samsungchallenge.view;

import android.content.Intent;
import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.controller.UserController;
import android.curso.samsungchallenge.model.User;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity {

    Button btnNewUser;
    EditText editTextUserName, editTextUserEmail, editTextUserPassword;

    public boolean validateUserName() {
        String userName = editTextUserName.getText().toString().trim();
        if (userName.isEmpty()) {
            editTextUserName.setError("Informe seu nome");
            return false;
        }
        return true;
    }

    public boolean validateUserEmail() {
        String userEmail = editTextUserEmail.getText().toString().trim();
        if (userEmail.isEmpty()) {
            editTextUserEmail.setError("Informe um e-mail");
            return false;
        }
        editTextUserEmail.setError(null);
        return true;
    }

    public boolean validateUserPassword() {
        String userPassword = editTextUserPassword.getText().toString().trim();
        if (userPassword.isEmpty()) {
            editTextUserPassword.setError("Informe uma senha");
            return false;
        }
        editTextUserPassword.setError(null);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextUserEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextUserPassword = (EditText) findViewById(R.id.editTextPassword);

        btnNewUser = findViewById(R.id.buttonNewUser);
        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUserName() == true && validateUserEmail() == true && validateUserPassword() == true) {
                    User obj = new User();
                    obj.setName(editTextUserName.getText().toString().trim());
                    obj.setEmail(editTextUserEmail.getText().toString().trim());
                    obj.setPassword(editTextUserPassword.getText().toString().trim());
                    UserController userController = new UserController(getBaseContext());
                    if (userController.store(obj) == true) {
                        Toast.makeText(getBaseContext(), "Tudo certo no seu cadastro " + editTextUserName.getText().toString().trim() + " !" , Toast.LENGTH_SHORT ).show();
                        Intent createNewUserActivity = new Intent(CreateUserActivity.this, MainActivity.class);
                        CreateUserActivity.this.startActivity(createNewUserActivity);
                    } else {
                        Toast.makeText(getBaseContext(), "Não foi possível realizar seu cadastro" , Toast.LENGTH_SHORT ).show();
                    }

                }
            }
        });
    }
}
