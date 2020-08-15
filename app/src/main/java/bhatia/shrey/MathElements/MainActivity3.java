package bhatia.shrey.MathElements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity3 extends AppCompatActivity {

    int playerProgress;
    int cpuProgress;
    int pos;
    int answerPos;
    int playerHealth;
    int cpuHealth;
    int num1;
    int num2;
    String difficulty;
    String elementPicked;
    TextView playerGameTextView;
    TextView cpuGameTextView;
    SeekBar playerSeekBar;
    SeekBar cpuSeekBar;
    TextView playerHealthTextView;
    TextView cpuHealthTextView;
    TextView questionTextView;
    Random rand;
    Button option0Button;
    Button option1Button;
    Button option2Button;
    Button option3Button;
    Button backButton;
    TextView resultTextView;
    TextView winnerTextView;
    Button playAgainButton;
    Button quitGameButton;
    boolean running;



    public void goBackToActivity2 (View v){
        playerSeekBar.setProgress(0);
        cpuSeekBar.setProgress(0);
        finish();
    }

    public void createQuestion() {

        if (elementPicked.equals("add") && difficulty.equals("single")) {
            num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
            questionTextView.setText(Integer.toString(num1) + " + " + Integer.toString(num2));

        } else if (elementPicked.equals("add") && difficulty.equals("double")) {
            num1 = rand.nextInt(90) + 10;
            num2 = rand.nextInt(90) + 10;
            questionTextView.setText(Integer.toString(num1) + " + " + Integer.toString(num2));

        } else if (elementPicked.equals("add") && difficulty.equals("triple")) {
            num1 = rand.nextInt(900) + 100;
            num2 = rand.nextInt(900) + 100;
            questionTextView.setText(Integer.toString(num1) + " + " + Integer.toString(num2));

        } else if (elementPicked.equals("sub") && difficulty.equals("single")) {
            num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
            while (num2 > num1) {
                num1 = rand.nextInt(10);
                num2 = rand.nextInt(10);
            }
            questionTextView.setText(Integer.toString(num1) + " - " + Integer.toString(num2));

        } else if (elementPicked.equals("sub") && difficulty.equals("double")) {
            num1 = rand.nextInt(90) + 10;
            num2 = rand.nextInt(10) + 10;
            while (num2 > num1) {
                num1 = rand.nextInt(91) + 10;
                num2 = rand.nextInt(91) + 10;
            }
            questionTextView.setText(Integer.toString(num1) + " - " + Integer.toString(num2));

        } else if (elementPicked.equals("sub") && difficulty.equals("triple")) {
            num1 = rand.nextInt(900) + 100;
            num2 = rand.nextInt(900) + 100;
            while (num2 > num1) {
                num1 = rand.nextInt(900) + 100;
                num2 = rand.nextInt(900) + 100;
            }
            questionTextView.setText(Integer.toString(num1) + " - " + Integer.toString(num2));

        } else if (elementPicked.equals("mul") && difficulty.equals("single")) {
            num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
            questionTextView.setText(Integer.toString(num1) + " × " + Integer.toString(num2));

        } else if (elementPicked.equals("mul") && difficulty.equals("double")) {
            num1 = rand.nextInt(90) + 10;
            num2 = rand.nextInt(10);
            questionTextView.setText(Integer.toString(num1) + " × " + Integer.toString(num2));

        } else if (elementPicked.equals("mul") && difficulty.equals("triple")) {
            num1 = rand.nextInt(900) + 100;
            num2 = rand.nextInt(10);
            questionTextView.setText(Integer.toString(num1) + " × " + Integer.toString(num2));

        } else if (elementPicked.equals("div") && difficulty.equals("single")) {
            num1 = rand.nextInt(9) + 1;
            num2 = rand.nextInt(9) + 1;
            while (divisorMethod(num1).size() < 3) {
                num1 = rand.nextInt(9) + 1;
            }
            while (num2 == 1 || !(num1 % num2 == 0)) {
                num2 = rand.nextInt(9) + 1;
            }

            questionTextView.setText(Integer.toString(num1) + " ÷ " + Integer.toString(num2));

        } else if (elementPicked.equals("div") && difficulty.equals("double")) {
            num1 = rand.nextInt(90) + 10;
            while (divisorMethod(num1).size() < 3) {
                num1 = rand.nextInt(90) + 10;
            }
            num2 = rand.nextInt(9) + 1;
            while (num2 == 1 || !(num1 % num2 == 0)) {
                num2 = rand.nextInt(9) + 1;
            }

            questionTextView.setText(Integer.toString(num1) + " ÷ " + Integer.toString(num2));
        } else {
            num1 = rand.nextInt(900) + 100;
            while (divisorMethod(num1).size() < 3) {
                num1 = rand.nextInt(900) + 100;
            }
            num2 = rand.nextInt(9) + 1;
            while (num2 == 1 || !(num1 % num2 == 0)) {
                num2 = rand.nextInt(9) + 1;
            }

            questionTextView.setText(Integer.toString(num1) + " ÷ " + Integer.toString(num2));
        }
    }

    private ArrayList<Integer> divisorMethod(int temp) {
        int count = 0;
        ArrayList<Integer> divisor = new ArrayList<>();

        for (int i = 1; i <= temp; i++) {
            if (temp % i == 0) {
                divisor.add(i);
            }
        }
        return divisor;
    }

    private void createOptions(int temp1, int temp2, String element) {
        int[] options = new int[4];
        Set <Integer> hashSet = new HashSet<>();
        int answer = 0;

        switch (element) {
            case "add":
                answer = temp1 + temp2;
                break;
            case "sub":
                answer = temp1 - temp2;
                break;
            case "mul":
                answer = temp1 * temp2;
                break;
            case "div":
                answer = temp1 / temp2;
        }

        answerPos = rand.nextInt(4);

        for (int pos = 0; pos < 4; pos++) {
            if (pos != answerPos) {
                if (answer < 10) {
                    int randPosNum = rand.nextInt(10);
                    while (randPosNum == answer || hashSet.contains(randPosNum)) {
                        randPosNum = rand.nextInt(10);
                    }
                    options[pos] = randPosNum;
                    hashSet.add(randPosNum);

                } else {
                    int randPosNum = rand.nextInt(21) + (answer - 10);
                    while (randPosNum == answer || hashSet.contains(randPosNum)) {
                        randPosNum = rand.nextInt(21) + (answer - 10);
                    }
                    options[pos] = randPosNum;
                    hashSet.add(randPosNum);
                }
            } else {
                options[pos] = answer;
            }
        }

        option0Button.setText(Integer.toString(options[0]));
        option1Button.setText(Integer.toString(options[1]));
        option2Button.setText(Integer.toString(options[2]));
        option3Button.setText(Integer.toString(options[3]));
    }

    public void displayQuestionsAndOptions() {
        option0Button.setVisibility(View.VISIBLE);
        option1Button.setVisibility(View.VISIBLE);
        option2Button.setVisibility(View.VISIBLE);
        option3Button.setVisibility(View.VISIBLE);
        questionTextView.animate().alpha(1f).setDuration(2000);
        option0Button.animate().alpha(1f).setDuration(2000);
        option1Button.animate().alpha(1f).setDuration(2000);
        option2Button.animate().alpha(1f).setDuration(2000);
        option3Button.animate().alpha(1f).setDuration(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                running = true;
            }
        }, 2000);

        //disableButton();


    }
    public void fadeQuestionsAndOptions(){

        questionTextView.animate().alpha(0f).setDuration(2000);
        option0Button.animate().alpha(0f).setDuration(2000);
        option1Button.animate().alpha(0f).setDuration(2000);
        option2Button.animate().alpha(0f).setDuration(2000);
        option3Button.animate().alpha(0f).setDuration(2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                option0Button.setVisibility(View.INVISIBLE);
                option1Button.setVisibility(View.INVISIBLE);
                option2Button.setVisibility(View.INVISIBLE);
                option3Button.setVisibility(View.INVISIBLE);
                playAgainButton.setVisibility(View.INVISIBLE);
                quitGameButton.setVisibility(View.INVISIBLE);
            }
        }, 2000);
        //disableButton();

    }
    public void displayAttackAndDamage(){
        resultTextView.animate().alpha(1f).setDuration(2000);
        //disableButton();


    }
    public void fadeDisplayAttackAndDamage(){
        resultTextView.animate().alpha(0f).setDuration(2000);
        //disableButton();


    }
    public void buttonTapped (View v) {
        if (running) {
            Button currentButton = (Button) v;
            pos = Integer.parseInt(currentButton.getTag().toString());
            attackAndDamageScreen(pos);
        }
    }
    public void attackAndDamageScreen (int temp){
        running = false;
        if (temp == answerPos) {
            resultTextView.setText("Correct!");
            fadeQuestionsAndOptions();
            displayAttackAndDamage();
            backButton.setVisibility(View.INVISIBLE);
            enableButton();
            final int playerDamage = rand.nextInt(10)+1;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    for (int i = 0; i < 1; i++) {
                        Toast.makeText(getApplicationContext(), "you dealt " + playerDamage + " damage on computer", Toast.LENGTH_LONG).show();
                    }
                    cpuHealth-= playerDamage;
                    cpuProgress+=playerDamage;
                    if (cpuHealth < 0){
                        cpuHealthTextView.setText("0/100 health");
                        cpuSeekBar.setProgress(100);
                    }
                    else {
                        cpuHealthTextView.setText(cpuHealth + "/100 health");
                        cpuSeekBar.setProgress(cpuProgress);
                    }

                }
            }, 1500);
            enableButton();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (cpuHealth < 0) {
                        playerWins();
                        fadeDisplayAttackAndDamage();

                    } else {
                        createQuestion();
                        createOptions(num1, num2, elementPicked);
                        displayQuestionsAndOptions();
                        fadeDisplayAttackAndDamage();
                    }
                }
            }, 5000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backButton.setVisibility(View.VISIBLE);
                }
            }, 7000);
        }
        else {
            resultTextView.setText("Incorrect!");
            fadeQuestionsAndOptions();
            displayAttackAndDamage();
            backButton.animate().alpha(0).setDuration(2000);
            final int cpuDamage = rand.nextInt(10)+1;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backButton.setVisibility(View.INVISIBLE);
                    for (int i = 0; i < 1; i++) {
                        Toast.makeText(getApplicationContext(), "computer dealt " + cpuDamage + " damage on you", Toast.LENGTH_LONG).show();
                    }
                    playerHealth-= cpuDamage;
                    playerProgress+=cpuDamage;
                    if (playerHealth < 0){
                        playerHealthTextView.setText("0/100 health");
                        playerSeekBar.setProgress(100);
                    }
                    else {
                        playerHealthTextView.setText(playerHealth + "/100 health");
                        playerSeekBar.setProgress(playerProgress);
                    }


                }
            }, 1500);
            enableButton();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (playerHealth < 0) {
                        cpuWins();
                        fadeDisplayAttackAndDamage();

                    } else {
                        createQuestion();
                        createOptions(num1, num2, elementPicked);
                        displayQuestionsAndOptions();
                        fadeDisplayAttackAndDamage();
                        backButton.animate().alpha(1f).setDuration(2000);
                    }
                }
            }, 5000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backButton.setVisibility(View.VISIBLE);
                }
            }, 7000);
        }
    }

    public void cpuWins(){
        option0Button.setVisibility(View.INVISIBLE);
        option1Button.setVisibility(View.INVISIBLE);
        option2Button.setVisibility(View.INVISIBLE);
        option3Button.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.VISIBLE);
        quitGameButton.setVisibility(View.VISIBLE);
        winnerTextView.setTextColor(Color.parseColor("#9C27B0"));
        playAgainButton.setBackgroundResource(R.drawable.rounded_button_purple);
        quitGameButton.setBackgroundResource(R.drawable.rounded_button_purple);
        winnerTextView.setText("Computer won!");
        winnerTextView.animate().alpha(1f).setDuration(2000);
        playAgainButton.animate().alpha(1f).setDuration(2000);
        quitGameButton.animate().alpha(1f).setDuration(2000);
        backButton.animate().alpha(0f).setDuration(2000);
    }

    public void playerWins(){
        option0Button.setVisibility(View.INVISIBLE);
        option1Button.setVisibility(View.INVISIBLE);
        option2Button.setVisibility(View.INVISIBLE);
        option3Button.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.VISIBLE);
        quitGameButton.setVisibility(View.VISIBLE);
        winnerTextView.setText("You won!");
        winnerTextView.animate().alpha(1f).setDuration(2000);
        playAgainButton.animate().alpha(1f).setDuration(2000);
        quitGameButton.animate().alpha(1f).setDuration(2000);
        backButton.animate().alpha(0f).setDuration(2000);

    }

    public void goBackToMain (View v){
        playerSeekBar.setProgress(0);
        cpuSeekBar.setProgress(0);
        Intent quitGame = new Intent (MainActivity3.this, MainActivity.class);
        startActivity(quitGame);
    }

    public void disableButton (){
        option0Button.setClickable(false);
        option1Button.setClickable(false);
        option2Button.setClickable(false);
        option3Button.setClickable(false);
        backButton.setClickable(false);
        playAgainButton.setClickable(false);
        quitGameButton.setClickable(false);
    }

    public void enableButton (){

        option0Button.setClickable(true);
        option1Button.setClickable(true);
        option2Button.setClickable(true);
        option3Button.setClickable(true);
        backButton.setClickable(true);
        playAgainButton.setClickable(true);
        quitGameButton.setClickable(true);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        playerGameTextView = (TextView) findViewById(R.id.playerElementGameTextView);
        cpuGameTextView = (TextView) findViewById(R.id.cpuElementGameTextView);
        playerSeekBar = (SeekBar) findViewById(R.id.playerSeekBar);
        cpuSeekBar = (SeekBar) findViewById(R.id.cpuSeekBar);
        playerHealthTextView = (TextView) findViewById(R.id.playerHealthTextView);
        cpuHealthTextView = (TextView) findViewById(R.id.cpuHealthTextView);
        questionTextView = (TextView) findViewById(R.id.questionTextView);
        rand = new Random();
        option0Button = (Button) findViewById(R.id.answerButton0);
        option1Button = (Button) findViewById(R.id.answerButton1);
        option2Button = (Button) findViewById(R.id.answerButton2);
        option3Button = (Button) findViewById(R.id.answerButton3);
        backButton = (Button) findViewById(R.id.backButtonGame);
        playerHealth = 100;
        cpuHealth = 100;
        num1 = 0;
        num2 = 0;
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        quitGameButton = (Button) findViewById(R.id.quitGameButton);


        playerGameTextView.setTranslationX(-1500f);
        cpuGameTextView.setTranslationX(-1500f);
        playerSeekBar.setTranslationX(1500f);
        cpuSeekBar.setTranslationX(1500f);
        playerHealthTextView.setTranslationX(1500f);
        cpuHealthTextView.setTranslationX(1500f);
        questionTextView.setAlpha(0f);
        option0Button.setAlpha(0f);
        option1Button.setAlpha(0f);
        option2Button.setAlpha(0f);
        option3Button.setAlpha(0f);
        backButton.setAlpha(0f);
        resultTextView.setAlpha(0f);
        winnerTextView.setAlpha(0f);
        playAgainButton.setAlpha(0f);
        quitGameButton.setAlpha(0f);
        playAgainButton.setVisibility(View.INVISIBLE);
        quitGameButton.setVisibility(View.INVISIBLE);
        option0Button.setVisibility(View.INVISIBLE);
        option1Button.setVisibility(View.INVISIBLE);
        option2Button.setVisibility(View.INVISIBLE);
        option3Button.setVisibility(View.INVISIBLE);
        running = true;



        cpuGameTextView.setBackgroundResource(R.drawable.circle_button_purple);
        cpuSeekBar.setProgressDrawable(getResources().getDrawable(R.drawable.seek_bar_purple));
        cpuHealthTextView.setTextColor(Color.parseColor("#9C27B0"));


        Intent elementSelected = getIntent();
        elementPicked = elementSelected.getStringExtra("element");
        difficulty = elementSelected.getStringExtra("difficulty");
        playerSeekBar.setProgress(0);
        cpuSeekBar.setProgress(0);
        playerSeekBar.setMax(100);
        cpuSeekBar.setMax(100);

        switch (elementPicked) {

            case "add": {
                playAgainButton.setBackgroundResource(R.drawable.rounded_button_blue);
                quitGameButton.setBackgroundResource(R.drawable.rounded_button_blue);
                winnerTextView.setTextColor(Color.parseColor("#00BCD4"));
                resultTextView.setTextColor(Color.parseColor("#00BCD4"));
                option0Button.setBackgroundResource(R.drawable.circle_button_blue);
                option1Button.setBackgroundResource(R.drawable.circle_button_blue);
                option2Button.setBackgroundResource(R.drawable.circle_button_blue);
                option3Button.setBackgroundResource(R.drawable.circle_button_blue);
                questionTextView.setTextColor(Color.parseColor("#00BCD4"));
                playerGameTextView.setBackgroundResource(R.drawable.circle_button_blue);
                playerGameTextView.setText("+");
                playerSeekBar.setProgressDrawable(getResources().getDrawable(R.drawable.seek_bar_blue));
                playerHealthTextView.setTextColor(Color.parseColor("#00BCD4"));
                playerGameTextView.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                playerSeekBar.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                playerHealthTextView.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                break;
            }

            case "sub": {
                playAgainButton.setBackgroundResource(R.drawable.rounded_button_brown);
                quitGameButton.setBackgroundResource(R.drawable.rounded_button_brown);
                winnerTextView.setTextColor(Color.parseColor("#cd853f"));
                resultTextView.setTextColor(Color.parseColor("#cd853f"));
                option0Button.setBackgroundResource(R.drawable.circle_button_brown);
                option1Button.setBackgroundResource(R.drawable.circle_button_brown);
                option2Button.setBackgroundResource(R.drawable.circle_button_brown);
                option3Button.setBackgroundResource(R.drawable.circle_button_brown);
                questionTextView.setTextColor(Color.parseColor("#cd853f"));
                playerGameTextView.setBackgroundResource(R.drawable.circle_button_brown);
                playerGameTextView.setText("—");
                playerSeekBar.setProgressDrawable(getResources().getDrawable(R.drawable.seek_bar_brown));
                playerHealthTextView.setTextColor(Color.parseColor("#cd853f"));
                playerGameTextView.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                playerSeekBar.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                playerHealthTextView.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                break;
            }

            case "mul": {
                playAgainButton.setBackgroundResource(R.drawable.rounded_button_red);
                quitGameButton.setBackgroundResource(R.drawable.rounded_button_red);
                winnerTextView.setTextColor(Color.parseColor("#F44336"));
                resultTextView.setTextColor(Color.parseColor("#F44336"));
                option0Button.setBackgroundResource(R.drawable.circle_button_red);
                option1Button.setBackgroundResource(R.drawable.circle_button_red);
                option2Button.setBackgroundResource(R.drawable.circle_button_red);
                option3Button.setBackgroundResource(R.drawable.circle_button_red);
                questionTextView.setTextColor(Color.parseColor("#F44336"));
                playerGameTextView.setBackgroundResource(R.drawable.circle_button_red);
                playerGameTextView.setText("×");
                playerSeekBar.setProgressDrawable(getResources().getDrawable(R.drawable.seek_bar_red));
                playerHealthTextView.setTextColor(Color.parseColor("#F44336"));
                playerGameTextView.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                playerSeekBar.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                playerHealthTextView.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                break;
            }

            case "div": {
                quitGameButton.setBackgroundResource(R.drawable.rounded_button_white);
                playAgainButton.setBackgroundResource(R.drawable.rounded_button_white);
                winnerTextView.setTextColor(Color.parseColor("#FFFFFF"));
                resultTextView.setTextColor(Color.parseColor("#FFFFFF"));
                option0Button.setBackgroundResource(R.drawable.circle_button_white);
                option1Button.setBackgroundResource(R.drawable.circle_button_white);
                option2Button.setBackgroundResource(R.drawable.circle_button_white);
                option3Button.setBackgroundResource(R.drawable.circle_button_white);
                questionTextView.setTextColor(Color.parseColor("#FFFFFF"));
                playerGameTextView.setBackgroundResource(R.drawable.circle_button_white);
                playerGameTextView.setText("÷");
                playerSeekBar.setProgressDrawable(getResources().getDrawable(R.drawable.seek_bar_white));
                playerHealthTextView.setTextColor(Color.parseColor("#FFFFFF"));
                playerGameTextView.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                playerSeekBar.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                playerHealthTextView.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                break;
            }
        }



        playerSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        cpuSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cpuGameTextView.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                cpuSeekBar.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                cpuHealthTextView.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);

            }
        }, 1000);

        createQuestion();
        createOptions(num1, num2, elementPicked);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                displayQuestionsAndOptions();
                backButton.animate().alpha(1f).setDuration(2000);
            }
        }, 3000);
       //  enableButton();



    }
}
