package com.example.sabak;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView1);
        etInput = findViewById(R.id.editText1);
        bControl = findViewById(R.id.button1);

        guess = (int)(Math.random() * 5);

        gameFinished = false;
    }

    public void onClick(View v) {

        if (!gameFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());

            if (inp > guess)
                tvInfo.setText("Слишком много");

            if (inp < guess)
                tvInfo.setText("Слишком мало");

            if (inp == guess) {
                tvInfo.setText("Ты угадал!");
                bControl.setText("Играть ещё");
                gameFinished = true;
            }
        } else {
            guess = (int)(Math.random() * 5);


            bControl.setText("Ввести число");
            tvInfo.setText("Попробуй угадать число");
            gameFinished = false;
        }

        etInput.setText("");
    }
}
