package br.edu.icomp.plaintext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("PlainText", "Activity principal criada");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("PlainText", "Método onStart executado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("PlainText", "Método onResume executado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("PlainText", "Método onPause executado");
    }

    public void onEnterClicked(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String prefLogin = sharedPreferences.getString("login", "");
        String prefPass = sharedPreferences.getString("password", "");

        String editLogin = ((EditText) findViewById(R.id.loginEditText)).getText().toString();
        String editPass = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();

        if (editLogin.equals(prefLogin) && editPass.equals(prefPass)) {
            Intent intent = new Intent(this, ListActivity.class);
            EditText inputLogin = findViewById(R.id.loginEditText);
            intent.putExtra("login", inputLogin.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login/Senha inválidos!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemAbout:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("PlainText Password Manager v1.0").setNeutralButton("Ok", null).show();
                return true;
            case R.id.menuItemSettings:
                startActivity(new Intent(this, PreferencesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}