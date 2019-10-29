package com.tom.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText number;
    TextView speak;
    Random random = new Random();
    int secert = random.nextInt(10)+1;
    int num;
    int counter =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        number = findViewById(R.id.number);
        speak = findViewById(R.id.speak);
        Log.d("Mainactive","secret :"+secert);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int secert2 = random.nextInt(10)+1;
                secert = secert2;
                Log.d("Mainactive","secret2 :"+secert2);
                counter=0;
            }
        });

    }
        public void guess(View view){
        num = Integer.parseInt(number.getText().toString());
            if (num>secert){
                counter++;
                speak.setText("too big, already guess "+counter + " times");
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Tip")
                        .setMessage("too big")
                        .setPositiveButton("OK",null)
                        .show();

            }
            else if (num<secert){
                counter++;
                speak.setText("too small, already guess "+counter + " times");
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Tip")
                        .setMessage("too small")
                        .setPositiveButton("OK",null)
                        .show();
            }
            else {
                speak.setText("right");
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Tip")
                        .setMessage("Bingo")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int secert2 = random.nextInt(10)+1;
                                secert = secert2;
                                Log.d("Mainactive","secret2 :"+secert2);
                                counter=0;
                            }
                        })
                        .show();

            }

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
