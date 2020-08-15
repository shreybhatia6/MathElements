package bhatia.shrey.MathElements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void goToActivity2 (View v){

        Button buttonPressed = (Button) v;
        String element = v.getTag().toString();

        Intent elementIntent = new Intent (MainActivity.this, MainActivity2.class);
        elementIntent.putExtra("element", element);
        startActivity(elementIntent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}