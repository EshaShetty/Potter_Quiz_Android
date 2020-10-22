package com.example.potterquizandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaring variables
    Button trueBtn, falseBtn;
    TextView question, score;
    ProgressBar bar;
    int count=0, scoreN=0;
    final int PROGRESS_BAR_INCREMENT = 8;

    //getting data from the string resources
    private QuestionBank[] questions = new QuestionBank[] {
            new QuestionBank(R.string.question_1, true),
            new QuestionBank(R.string.question_2, false),
            new QuestionBank(R.string.question_3, true),
            new QuestionBank(R.string.question_4, false),
            new QuestionBank(R.string.question_5, false),
            new QuestionBank(R.string.question_6, false),
            new QuestionBank(R.string.question_7, false),
            new QuestionBank(R.string.question_8, true),
            new QuestionBank(R.string.question_9, true),
            new QuestionBank(R.string.question_10, false),
            new QuestionBank(R.string.question_11, false),
            new QuestionBank(R.string.question_12, true),
            new QuestionBank(R.string.question_13,false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attaching the view to the variables
        trueBtn = findViewById(R.id.true_btn);
        falseBtn = findViewById(R.id.false_btn);
        question = findViewById(R.id.question);
        score = findViewById(R.id.score);
        bar = findViewById(R.id.progressBar);


        //first question when application is created
        question.setText(questions[count].getQuestionId());

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(true);
                changeQuestion();
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(false);
                changeQuestion();
            }
        });
    }

    private void changeQuestion()
    {
        bar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        score.setText("Score "+scoreN+"/13");
        if(count!=questions.length-1) {
            count += 1;
            question.setText(questions[count].getQuestionId());
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your score is: "+scoreN+"/13");
            alert.setPositiveButton("Exit Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }
    }

    private void checkAns(boolean userSelection)
    {
        boolean rAns = questions[count].isAnswer();
        if(userSelection==rAns){
            scoreN+=1;
        }
    }
}