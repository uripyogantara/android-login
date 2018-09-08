package id.technologyartisan.loginandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btnLogin;

    private final String USERNAME="admin";
    private final String PASSWORD="123456";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences=getSharedPreferences("user", Context.MODE_PRIVATE);
        String login=sharedPreferences.getString("login","");
//        if (login==true){
//            Intent intent=new Intent(this,MainActivity.class);
//            startActivity(intent);
//        }
        setContentView(R.layout.activity_login);


        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        btnLogin=findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername=etUsername.getText().toString();
                String inputPassword=etPassword.getText().toString();

                if (inputUsername.equals(USERNAME)&&inputPassword.equals(PASSWORD)){
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    sharedPreferences.edit()
                            .putBoolean("login",true)
                            .putString("nama","urip")
                            .putString("username",inputUsername)
                            .putInt("umur",21)
                            .apply();

                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
