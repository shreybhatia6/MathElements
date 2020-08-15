package bhatia.shrey.MathElements;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String elementPicked;
    TextView playerElement;
    TextView player;
    TextView vs;
    TextView cpuElement;
    TextView cpu;
    TextView difficulty;
    Button singleDigit;
    Button doubleDigit;
    Button tripleDigit;
    Button back;

    public void goBackToActivity1 (View v){
        finish();
    }

    public void goToActivity3 (View v){
        Button buttonPressed = (Button) v;
        String difficulty = v.getTag().toString();

        Intent difficultyIntent = new Intent (MainActivity2.this, MainActivity3.class);
        difficultyIntent.putExtra("element", elementPicked);
        difficultyIntent.putExtra("difficulty", difficulty);
        startActivity(difficultyIntent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        playerElement = (TextView) findViewById(R.id.playerElementTextView);
        player = (TextView) findViewById(R.id.playerTextView);
        vs = (TextView) findViewById(R.id.vsTextView);
        cpuElement = (TextView) findViewById(R.id.cpuElementTextView);
        cpu = (TextView) findViewById(R.id.cpuTextView);
        difficulty = (TextView) findViewById(R.id.difficultyTextView);
        singleDigit = (Button) findViewById(R.id.singleDigitButton);
        doubleDigit = (Button) findViewById(R.id.doubleDigitButton);
        tripleDigit = (Button) findViewById(R.id.tripleDigitButton);
        back = (Button) findViewById(R.id.backButton);

        playerElement.setTranslationX(-1500f);
        player.setTranslationX(1500f);
        cpuElement.setTranslationX(-1500f);
        cpu.setTranslationX(1500f);
        vs.setAlpha(0f);
        difficulty.setAlpha(0f);
        singleDigit.setAlpha(0f);
        doubleDigit.setAlpha(0f);
        tripleDigit.setAlpha(0f);
        back.setVisibility(View.INVISIBLE);

        Intent elementSelected = getIntent();
        elementPicked = elementSelected.getStringExtra("element");

        switch (elementPicked) {

            case "add": {
                singleDigit.setBackgroundResource(R.drawable.rounded_button_blue);
                doubleDigit.setBackgroundResource(R.drawable.rounded_button_blue);
                tripleDigit.setBackgroundResource(R.drawable.rounded_button_blue);
                player.setTextColor(Color.parseColor("#00BCD4"));
                playerElement.setText("+");
                playerElement.setBackgroundResource(R.drawable.circle_button_blue);
                playerElement.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                player.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                break;
            }
            case "sub": {
                singleDigit.setBackgroundResource(R.drawable.rounded_button_brown);
                doubleDigit.setBackgroundResource(R.drawable.rounded_button_brown);
                tripleDigit.setBackgroundResource(R.drawable.rounded_button_brown);
                player.setTextColor(Color.parseColor("#cd853f"));
                playerElement.setText("—");
                playerElement.setBackgroundResource(R.drawable.circle_button_brown);
                playerElement.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                player.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                break;
            }
            case "mul": {
                singleDigit.setBackgroundResource(R.drawable.rounded_button_red);
                doubleDigit.setBackgroundResource(R.drawable.rounded_button_red);
                tripleDigit.setBackgroundResource(R.drawable.rounded_button_red);
                player.setTextColor(Color.parseColor("#F44336"));
                playerElement.setText("×");
                playerElement.setBackgroundResource(R.drawable.circle_button_red);
                playerElement.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                player.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                break;
            }

            case "div": {
                singleDigit.setBackgroundResource(R.drawable.rounded_button_white);
                doubleDigit.setBackgroundResource(R.drawable.rounded_button_white);
                tripleDigit.setBackgroundResource(R.drawable.rounded_button_white);
                player.setTextColor(Color.parseColor("#FFFFFF"));
                playerElement.setText("÷");
                playerElement.setBackgroundResource(R.drawable.circle_button_white);
                playerElement.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                player.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
                break;


            }

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                vs.animate().alpha(1f).setDuration(2000);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cpuElement.animate().translationXBy(1500f).rotationBy(360).setDuration(2000);
                cpu.animate().translationXBy(-1500f).rotationBy(360).setDuration(2000);
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                difficulty.animate().alpha(1f).setDuration(2000);
                singleDigit.animate().alpha(1f).setDuration(2000);
                doubleDigit.animate().alpha(1f).setDuration(2000);
                tripleDigit.animate().alpha(1f).setDuration(2000);

            }
        }, 5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                back.setVisibility(View.VISIBLE);
            }
        }, 7000);



    }

}