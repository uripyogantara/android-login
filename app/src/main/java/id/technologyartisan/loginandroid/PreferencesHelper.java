package id.technologyartisan.loginandroid;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private SharedPreferences sharedPreferences;

    public PreferencesHelper(Context context) {
        sharedPreferences=context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public void setLogin(boolean login){
        sharedPreferences.edit()
                .putBoolean("login",login)
                .apply();
    }

    public void setNama(String nama){
        sharedPreferences.edit()
                .putString("nama",nama)
                .apply();
    }

    public boolean getLogin(){
        return sharedPreferences.getBoolean("login",false);
    }
}
