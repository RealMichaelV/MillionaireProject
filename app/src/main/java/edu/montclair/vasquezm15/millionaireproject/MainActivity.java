package edu.montclair.vasquezm15.millionaireproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView q1;//this is assigned to the count of a textview of the count of question
    private TextView earned; // just earned during the millionaire game
    private  String  Worth; //previous question worth
    private TextView question; // this textview will display our questions
    private Button Answer1; // this is answer choice 1
    private Button Answer2; // this is answer choice 2
    private Button Answer3; //this is answer choice 3
    private  Button Answer4; // this is answer choice 4


    private String CorrectAnswer; //our correct answer it will let us know whats the correct answer
    private int CorrectAnswerCounter = 0; // assigned int to 1 of the counter of correct answer
    private int TheQuizCounter = 1; // assigned 1 as the counter of the quiz because this later will be assigned to ten questions
    static final private int Quiz_Counter = 10; // assigned the counter to 10 because were choosing only 10 questions for the millionaire game


    ArrayList<ArrayList<String>> TheQuizArray = new ArrayList<>(); // array list of TheQuizArray

    String QuizKnowledge[][] = {
            //{"Question", "Answer", "Choice1","Choice2","Choice3","Previous earned", "just earned from right question"}
            {"In the Uk, the abbreviation NHS stands for National what service?", "Health", "Household", "Honour", "Humanity","0", "200"},
            {"Which of these brands was chiefly associated with the manufacture of household locks?", "Chubb", "Phillips", "Flymo", "Ronseal","200", "300"},
            {"The Earth is approximately how many miles away from the sun?", "93 million", "39 million", "9.3 million","193 million","300", "500"},
            {"Which insect shorted out an early supercomputer and inspired the term computer bug?", "Moth", "Roach", "Fly", "Japanese beetle","500", "1500"},
            {"Which of the following landlocked countries is entirely contained within another country?", "Lesotho", "Burkina Faso", "Mongolia", "Luxembourg", "1500", "5000"},
            {"What letter must appear at the beginning of the registration number of non-military aircrafts in the U.S.?", "N", "A", "U","L","5000", "16000"},
            {"Who did artist Grant Wood use as the model for the farmer in his classic painting American Gothic?", "his dentist", "traveling salesman", "local sheriff", "his butcher","16000", "125000"},
            {"The song God Bless America was originally written for what 1918 musical?", "Yip Yip Yaphank", "Blossom time", "Oh lady lady", "watch your step","125000", "250000"},
            {"What club did astronaut Alan Shepard use to make his famous golf shot on the moon?", "six iron", "seven iron", "nine iron", "sand wedge","250000", "500000"},
            {"How many days make up a non-leap year in the islamic calendar?", "354", "400", "365", "376","500000", "1000000"}

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // hide the title bar

       q1 = findViewById(R.id.q1);
       question = findViewById(R.id.question); // assigning the variable ids
        earned = findViewById(R.id.earned);
       Answer1 = findViewById(R.id.answer1); // assigning the variable ids
       Answer2 = findViewById(R.id.answer2); // assigning the variable ids
       Answer3 = findViewById(R.id.answer3); // assigning the variable ids
       Answer4 = findViewById(R.id.answer4); //assigning the variable ids

       for(int i = 0; i < QuizKnowledge.length; i++){ // assigning the length and with increments

           ArrayList<String> nexArray = new ArrayList<>(); // arraylist of nexarray
           nexArray.add(QuizKnowledge[i][0]); //Question
           nexArray.add(QuizKnowledge[i][1]); //Right answer
           nexArray.add(QuizKnowledge[i][2]); // Choice 1
           nexArray.add(QuizKnowledge[i][3]); // Choice 2
           nexArray.add(QuizKnowledge[i][4]);   //Choice 3
           nexArray.add(QuizKnowledge[i][5]); //previous earning
           nexArray.add(QuizKnowledge[i][6]); //earned from the question

           //Add another Array
           TheQuizArray.add(nexArray);

       }

       NextQuiz(); //next question of the quiz


    }



    private void NextQuiz() {
        q1.setText("Q" + TheQuizCounter);//displaying the counter of the question on which one you are on
        int index = 0;
        ArrayList<String> TheQuiz = TheQuizArray.get(index); // Array List with random of the quiz
        question.setText(TheQuiz.get(0)); // choosing the question and displaying them
        Worth = TheQuiz.get(6);
        earned.setText(TheQuiz.get(5));
        CorrectAnswer = TheQuiz.get(1); // will show if correct or wrong later of the quiz while choosing the answer choices.


        TheQuiz.remove(0);

        Answer1.setText(TheQuiz.get(0)); // it will display answer 1 choice
        Answer2.setText(TheQuiz.get(1)); // it will display answer 2 choice
        Answer3.setText(TheQuiz.get(2)); // it will display answer 3 choice
        Answer4.setText(TheQuiz.get(3)); // it will display answer 4 choice
        TheQuizArray.remove(index);

        if (index < TheQuizArray.size() - 1) {
            index++;
        } else {
            index = 0;
        }
    }
    public void CheckTheAns(View view){
        Button answerbutton = (Button) findViewById(view.getId());
     String getText = answerbutton.getText().toString();

     // this is where you choose your answer and get a dialog box showing if it right or wrong and shows you what the right answer is
        String alertnotify;
     if (getText.equals(CorrectAnswer)){
         //if the answer is correct
         alertnotify = "Your Choose is Correct";
         Toast toast = Toast.makeText(getApplicationContext(),"You have earned $ " + Worth,Toast.LENGTH_LONG);
         toast.show();
         CorrectAnswerCounter++;

     } else {
         //if the answer is wrong
       Toast toast = Toast.makeText(getApplicationContext(),"Sorry this is the wrong Answer",Toast.LENGTH_LONG);
       toast.show();


         Intent intent = new Intent(MainActivity.this, LostUI.class);
         startActivity(intent);
         finish();
     }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

                if (TheQuizCounter == Quiz_Counter) {
                    Intent intent = new Intent(getApplicationContext(), WinUi.class);
                    intent.putExtra("Correct_Answer", CorrectAnswerCounter); // this is the intent that will display the high score and your score at the end of the quiz card game
                    startActivity(intent); // start the intent

                } else {
                    TheQuizCounter++; //quizcounter being incremented
                    NextQuiz(); //next question

                }




            }


    }



