package edu.montclair.vasquezm15.millionaireproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinUi extends AppCompatActivity {
    private Button playbutton; //Play button to play the game again
    SharedPreferences DataSettings; //SharedPreference is what i used to share a database within the localhost of the android phone to store the login details
    SharedPreferences.Editor editor; // sharedpreferences editor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_ui);
        playbutton = findViewById(R.id.playbutton); // id assigned to a variable
        getSupportActionBar().hide(); //hide the title bar

        playbutton.setOnClickListener(new View.OnClickListener() { //on click listener when the button play again will be sent back to the millionaire game
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WinUi.this, MainActivity.class); // this intent will start the quiz game
                startActivity(intent); // starting the intent
                finish(); //will finish it by closing it off so you can't go back

            }
        });
    }
}