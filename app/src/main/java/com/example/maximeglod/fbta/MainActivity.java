package com.example.maximeglod.fbta;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inscription = (Button) findViewById(R.id.Button01);
        inscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Inscription.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button alimentation = (Button) findViewById(R.id.Button02);
        alimentation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), MainAliments.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}