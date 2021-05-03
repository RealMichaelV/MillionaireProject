package edu.montclair.vasquezm15.millionaireproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LostUI extends AppCompatActivity {
    private Button AgainButton; // button assigned to a variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_u_i);
        AgainButton = findViewById(R.id.playbutton); // id assigned to a variable
        getSupportActionBar().hide(); // hide the title bar
        AgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LostUI.this, MainActivity.class); // this intent will start the quiz game
                startActivity(intent); // starting the intent
                finish(); //will finish it by closing it off so you can't go back

            }
        });

    }
}