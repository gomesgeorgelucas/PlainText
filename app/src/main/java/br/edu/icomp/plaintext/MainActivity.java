package br.edu.icomp.plaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

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
        Toast.makeText(this, "Hi there!", Toast.LENGTH_SHORT).show();
    }
}