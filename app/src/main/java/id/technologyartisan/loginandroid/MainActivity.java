package id.technologyartisan.loginandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button btnLogout;
    SharedPreferences sharedPreferences;
    PreferencesHelper preferencesHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesHelper=new PreferencesHelper(getApplicationContext());
        preferencesHelper.setLogin(false);
        preferencesHelper.setNama("urip");
        sharedPreferences=getSharedPreferences("user", Context.MODE_PRIVATE);

        final String nama=sharedPreferences.getString("nama","gak ketemu");
//        int umur=sharedPreferences.getInt("umur",0)
        text=findViewById(R.id.text);
        btnLogout=findViewById(R.id.btn_logout);
        text.setText(nama);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit()
                        .clear()
                        .apply();

                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
