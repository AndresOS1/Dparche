package com.example.deplegable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Emojis extends AppCompatActivity {

    ImageView tristreza;
    ImageView enojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emojis);

        referenciar();
    }

    private void referenciar() {
        tristreza=findViewById(R.id.imagetristeza);
        TranslateAnimation translateAnimation1 = new TranslateAnimation(0.0f, 1600.0f, 0.0f, 0.0f);
        translateAnimation1.setDuration(2166);
        tristreza.startAnimation(translateAnimation1);

        enojo=findViewById(R.id.imagefuria);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1600.0f, 0.0f, 1600.0f, 0.0f);
        translateAnimation2.setDuration(2166);
        enojo.startAnimation(translateAnimation2);
    }

}